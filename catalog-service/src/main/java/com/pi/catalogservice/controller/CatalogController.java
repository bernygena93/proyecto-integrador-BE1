package com.pi.catalogservice.controller;

import com.pi.catalogservice.persistence.dto.Movie;
import com.pi.catalogservice.persistence.dto.Serie;
import com.pi.catalogservice.persistence.entity.Catalog;
import com.pi.catalogservice.service.ICatalogService;
import com.pi.catalogservice.service.IMovieService;
import com.pi.catalogservice.service.ISerieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/catalog")
public class CatalogController {
    private ICatalogService iCatalogService;
    private IMovieService iMovieService;
    private ISerieService iSerieService;
    @Autowired
    private RestTemplate restTemplate;

    public CatalogController(ICatalogService iCatalogService, IMovieService iMovieService, ISerieService iSerieService) {
        this.iCatalogService = iCatalogService;
        this.iMovieService = iMovieService;
        this.iSerieService = iSerieService;
    }

    @GetMapping(path = "/{genre}")
    ResponseEntity<Catalog> findByGenre(@PathVariable String genre){
        try{
            Catalog catalog = iCatalogService.findByGenre(genre);
            log.info("hasta aca llegue");
            return ResponseEntity.ok(catalog);
        }catch (Exception e){
            throw new Error("No se pudo obtener el catalogo de peliculas y series");
        }
    }

    @GetMapping(path = "movie/{genre}")
    ResponseEntity<List<Movie>> findAllByGenre(@PathVariable String genre){
        try{
            List<Movie> movies = iMovieService.findAllByGenre(genre);
            return ResponseEntity.ok(movies);
        }catch (Exception e){
            throw new Error("No se pudo obtener el catalogo de peliculas y series");
        }
    }

    @PostMapping(path = "/movie")
    ResponseEntity saveMovie(@RequestBody Movie movie){
        try{
            iMovieService.save(movie);
            String response = restTemplate.getForObject("http://localhost:8080/catalog/movie", String.class);
            return ResponseEntity.ok("Ok - " + response);
        }catch(Exception e){
            throw new Error("No se pudo crear la pelicula", e);
        }
    }

    @PostMapping(path = "/serie")
    ResponseEntity saveSerie(@RequestBody Serie serie){
        try{
            iSerieService.save(serie);
            String response = restTemplate.getForObject("http://localhost:8080/catalog/serie", String.class);
            return ResponseEntity.ok("Ok - " + response);
        }catch(Exception e){
            throw new Error("No se pudo crear la pelicula", e);
        }
    }
}
