package com.pi.catalogservice.domain.respository.feign;

import com.pi.catalogservice.domain.model.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@FeignClient(name = "movie-service")
public interface MovieFeignRepository {
    @PostMapping("/movie")
    Object save(@RequestBody Movie movie);

    @GetMapping("/movie/{genre}")
    List<Movie> findAllByGenre(@PathVariable String genre);
}
