package com.pi.movieservice.api.controller;

import com.pi.movieservice.domain.entity.Movie;
import com.pi.movieservice.api.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.PUT,
        RequestMethod.DELETE})
@RequestMapping(path = "/movie")
public class MovieController {
    private IMovieService iMovieService;

    @Autowired
    public MovieController(IMovieService iMovieService) {
        this.iMovieService = iMovieService;
    }

    @PostMapping(path = "")
    public ResponseEntity save(@RequestBody Movie movie) {
        try{
            iMovieService.save(movie);
            return ResponseEntity.ok(HttpStatus.OK);
        }catch(Exception e){
            throw new Error("No se pudo agregar la pelicula correspondiente",e);
        }
    }

    @GetMapping(path = "/{genre}")
    public ResponseEntity<List<Movie>> findAllByGenre(@PathVariable String genre) {
        try{
            List<Movie> movies = iMovieService.findAllByGenre(genre);
            return ResponseEntity.ok(movies);
        }catch(Exception e){
            throw new Error("No se pudo obtener el listado de peliculas",e);
        }
    }
}
