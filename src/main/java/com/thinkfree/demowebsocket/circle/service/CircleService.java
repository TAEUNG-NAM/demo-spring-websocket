package com.thinkfree.demowebsocket.circle.service;

import com.thinkfree.demowebsocket.circle.domain.Circle;
import com.thinkfree.demowebsocket.circle.dto.CreateCircleRequest;
import com.thinkfree.demowebsocket.circle.repository.CircleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CircleService {

    private final CircleRepository circleRepository;

    public Circle createCircle(CreateCircleRequest request) {
        Circle savedCircle = request.toEntity();
        return circleRepository.save(savedCircle);
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
