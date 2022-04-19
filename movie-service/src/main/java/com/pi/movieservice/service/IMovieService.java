package com.pi.movieservice.service;

import com.pi.movieservice.persistence.entity.Movie;

import java.util.List;

public interface IMovieService {
    void save(Movie movie);
    List<Movie> findAllByGenre(String genre);
}
