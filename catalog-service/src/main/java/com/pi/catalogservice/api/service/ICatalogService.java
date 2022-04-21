package com.pi.catalogservice.api.service;

import com.pi.catalogservice.domain.entity.Catalog;
import com.pi.catalogservice.domain.model.Movie;
import com.pi.catalogservice.domain.model.Serie;


public interface ICatalogService {
    Catalog findByGenre(String genre);
    void movieSave(Movie movie);
    void serieSave(Serie serie);
}
