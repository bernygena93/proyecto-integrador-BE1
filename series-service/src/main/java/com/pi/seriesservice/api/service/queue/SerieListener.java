package com.pi.seriesservice.api.service.queue;

import com.pi.seriesservice.api.service.impl.SerieService;
import com.pi.seriesservice.domain.entity.Serie;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SerieListener {

    private final SerieService serieService;

    @RabbitListener(queues = { "${queue.movie.name}" })
    public void receive(@Payload Serie serie) {
        serieService.save(serie);
    }
}
