package com.pi.seriesservice.api.service;

import com.pi.seriesservice.domain.entity.Serie;

import java.util.List;

public interface ISerieService {
    void save(Serie serie);
    List<Serie> findAllByGenre(String genre);
}
