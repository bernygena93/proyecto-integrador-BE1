package com.pi.catalogservice.api.queue;

import com.pi.catalogservice.domain.model.Movie;
import com.pi.catalogservice.domain.model.Serie;
import com.pi.catalogservice.domain.respository.feign.MovieFeignRepository;
import com.pi.catalogservice.domain.respository.feign.SerieFeignRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SerieSender {

    private final SerieFeignRepository serieFeignRepository;

    private final RabbitTemplate rabbitTemplate;

    private final Queue serieQueue;

    public void send(Serie serie) {
        this.rabbitTemplate.convertAndSend(this.serieQueue.getName(), serieFeignRepository.save(serie));
    }

}
