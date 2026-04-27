package com.thinkfree.demowebsocket.circle.repository;


import com.thinkfree.demowebsocket.circle.domain.Circle;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface CircleRepository extends MongoRepository<Circle, String> {
}
