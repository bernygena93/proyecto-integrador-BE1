package com.pi.catalogservice.api.service.impl;

import com.pi.catalogservice.domain.entity.Catalog;
import com.pi.catalogservice.domain.model.Movie;
import com.pi.catalogservice.domain.model.Serie;
import com.pi.catalogservice.domain.respository.CatalogRepository;
import com.pi.catalogservice.api.service.ICatalogService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CatalogService implements ICatalogService {
    private CatalogRepository catalogRepository;

    public CatalogService(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    @Override
    public Catalog findByGenre(String genre) {
        return catalogRepository.findByGenre(genre);
    }

    @Override
    public void movieSave(Movie movie) {
        Catalog catalog = catalogRepository.findByGenre(movie.getGenre());
        List<Movie> movies = catalog.getMovies();
        movies.add(movie);
        catalog.setMovies(movies);
        catalogRepository.save(catalog);
    }

    @Override
    public void serieSave(Serie serie) {
        Catalog catalog = catalogRepository.findByGenre(serie.getGenre());
        List<Serie> series = catalog.getSeries();
        series.add(serie);
        catalog.setSeries(series);
        catalogRepository.save(catalog);
    }

}
