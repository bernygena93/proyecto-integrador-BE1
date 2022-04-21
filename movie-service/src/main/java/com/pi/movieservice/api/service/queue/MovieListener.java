package com.pi.movieservice.api.service.queue;

import com.pi.movieservice.api.service.impl.MovieService;
import com.pi.movieservice.domain.entity.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MovieListener {

    private final MovieService movieService;

    @RabbitListener(queues = { "${queue.movie.name}" })
    public void receive(@Payload Movie movie) {
        movieService.save(movie);
    }
}
