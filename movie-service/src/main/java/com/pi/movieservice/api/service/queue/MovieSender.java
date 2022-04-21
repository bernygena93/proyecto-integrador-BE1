package com.pi.movieservice.api.service.queue;

import com.pi.movieservice.api.service.impl.MovieService;
import com.pi.movieservice.domain.entity.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class MovieSender {

    private final MovieService movieService;

    private final RabbitTemplate rabbitTemplate;

    private final Queue queueMovie;


    public void send(Movie movie){
        rabbitTemplate.convertAndSend(queueMovie.getName(),movieService.save(movie));
    }
}