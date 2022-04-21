package com.pi.movieservice.api.service.impl;

import com.pi.movieservice.api.service.IMovieService;
import com.pi.movieservice.domain.entity.Movie;
import com.pi.movieservice.domain.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public List<Movie> findAllByGenre(String genre) {
        return movieRepository.findAllByGenre(genre);
    }
}
