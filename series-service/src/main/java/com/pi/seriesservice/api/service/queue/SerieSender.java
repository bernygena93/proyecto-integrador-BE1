package com.pi.seriesservice.api.service.queue;

import com.pi.seriesservice.domain.entity.Serie;
import com.pi.seriesservice.domain.model.repository.SerieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SerieSender {

    private final SerieRepository serieRepository;

    private final RabbitTemplate rabbitTemplate;

    private final Queue serieQueue;

    public void send(Serie serie) {
        rabbitTemplate.convertAndSend(this.serieQueue.getName(), serieRepository.save(serie));
    }

}
