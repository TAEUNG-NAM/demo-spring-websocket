package com.thinkfree.demowebsocket.circle.service;

import com.thinkfree.demowebsocket.circle.domain.Circle;
import com.thinkfree.demowebsocket.circle.dto.CreateCircleRequest;
import com.thinkfree.demowebsocket.circle.repository.CircleRepository;
import com.thinkfree.demowebsocket.common.dto.WsMessage;
import com.thinkfree.demowebsocket.cursor.dto.WsAction;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CircleService {

    private final CircleRepository circleRepository;
    private final SimpMessagingTemplate messagingTemplate;

    public Circle createCircle(CreateCircleRequest request) {
        Circle circle = circleRepository.save(request.toEntity());
        messagingTemplate.convertAndSend("/topic/canvas", new WsMessage<>(WsAction.CIRCLE_CREATED, circle));
        return circle;
    }

    public List<Circle> getAllCircles() {
        return circleRepository.findAll();
    }

    public Circle getCircle(String id) {
        Circle circle = circleRepository.findById(id).get();
        log.info(circle.toString());
        return circle;
    }

    public void deleteCircle(List<String> ids) {
        circleRepository.deleteAllById(ids);
    }
}
