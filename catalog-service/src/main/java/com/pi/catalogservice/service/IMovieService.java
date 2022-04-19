package com.pi.catalogservice.service;


import com.pi.catalogservice.persistence.dto.Movie;

import java.util.List;

public interface IMovieService {
    void save(Movie movie);
    List<Movie> findAllByGenre(String genre);
}
