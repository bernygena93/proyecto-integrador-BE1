package com.pi.catalogservice.api.service;


import com.pi.catalogservice.domain.model.Movie;

import java.util.List;

public interface IMovieService {
    void save(Movie movie);
    List<Movie> findAllByGenre(String genre);
}
