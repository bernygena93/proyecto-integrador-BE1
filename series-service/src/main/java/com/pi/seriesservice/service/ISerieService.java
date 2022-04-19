package com.pi.seriesservice.service;

import com.pi.seriesservice.persistence.entity.Serie;

import java.util.List;

public interface ISerieService {
    void save(Serie serie);
    List<Serie> findAllByGenre(String genre);
}
