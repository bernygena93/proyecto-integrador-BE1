package com.pi.catalogservice.service.impl;

import com.pi.catalogservice.persistence.dto.Movie;
import com.pi.catalogservice.persistence.entity.Catalog;
import com.pi.catalogservice.persistence.respository.CatalogRepository;
import com.pi.catalogservice.persistence.respository.feign.MovieFeignRepository;
import com.pi.catalogservice.service.IMovieService;
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
