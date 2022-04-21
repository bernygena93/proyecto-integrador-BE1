package com.pi.catalogservice.api.queue;

import com.pi.catalogservice.api.service.impl.CatalogService;
import com.pi.catalogservice.domain.model.Movie;
import com.pi.catalogservice.domain.model.Serie;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class Listener {

    private final CatalogService catalogService;

    @RabbitListener(queues = { "${queue.movie.name}" })
    public void receive(@Payload Movie movie) {
        catalogService.movieSave(movie);
    }

    @RabbitListener(queues = { "${queue.serie.name}" })
    public void receive(@Payload Serie serie) {
        catalogService.serieSave(serie);
    }
}