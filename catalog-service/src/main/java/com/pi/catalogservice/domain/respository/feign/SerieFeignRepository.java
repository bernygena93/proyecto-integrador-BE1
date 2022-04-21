package com.pi.catalogservice.domain.respository.feign;

import com.pi.catalogservice.domain.model.Serie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@FeignClient(name = "series-service")
public interface SerieFeignRepository {
    @PostMapping("/serie")
    Object save(@RequestBody Serie serie);

    @GetMapping("/serie/{genre}")
    List<Serie> findAllByGenre(@PathVariable String genre);
}
