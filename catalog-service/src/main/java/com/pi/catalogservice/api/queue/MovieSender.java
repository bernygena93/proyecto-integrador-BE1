package com.pi.catalogservice.api.queue;

import com.pi.catalogservice.domain.model.Movie;
import com.pi.catalogservice.domain.respository.feign.MovieFeignRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovieSender {

    private final MovieFeignRepository movieFeignRepository;

    private final RabbitTemplate rabbitTemplate;

    private final Queue movieQueue;

    public void send(Movie movie) {
        this.rabbitTemplate.convertAndSend(this.movieQueue.getName(), movieFeignRepository.save(movie));
    }

}
