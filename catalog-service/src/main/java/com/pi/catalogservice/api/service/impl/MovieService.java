package com.pi.catalogservice.api.service.impl;

import com.pi.catalogservice.api.service.IMovieService;
import com.pi.catalogservice.domain.model.Movie;
import com.pi.catalogservice.domain.entity.Catalog;
import com.pi.catalogservice.domain.respository.CatalogRepository;
import com.pi.catalogservice.domain.respository.feign.MovieFeignRepository;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService {
    private MovieFeignRepository movieFeignRepository;
    private CatalogRepository catalogRepository;

    public MovieService(MovieFeignRepository movieFeignRepository, CatalogRepository catalogRepository) {
        this.movieFeignRepository = movieFeignRepository;
        this.catalogRepository = catalogRepository;
    }

    @CircuitBreaker(name = "movies", fallbackMethod = "getAllCatalogFallbackMethod")
    @Retry(name = "movies")
    @Override
    public void save(Movie movie) {
        movieFeignRepository.save(movie);
    }

    @CircuitBreaker(name = "movies", fallbackMethod = "getAllCatalogFallbackMethod")
    @Retry(name = "movies")
    @Override
    public List<Movie> findAllByGenre(String genre) {
        return movieFeignRepository.findAllByGenre(genre);
    }

    List<Catalog> getAllCatalogFallbackMethod(CallNotPermittedException exception){
        return catalogRepository.findAll();
    }

}
