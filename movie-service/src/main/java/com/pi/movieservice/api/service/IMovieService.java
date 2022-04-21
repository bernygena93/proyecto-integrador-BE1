package com.pi.movieservice.api.service;

import com.pi.movieservice.domain.entity.Movie;

import java.util.List;

public interface IMovieService {
    void save(Movie movie);
    List<Movie> findAllByGenre(String genre);
}
