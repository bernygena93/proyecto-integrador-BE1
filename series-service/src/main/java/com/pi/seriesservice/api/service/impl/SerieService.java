package com.pi.seriesservice.api.service.impl;

import com.pi.seriesservice.api.service.ISerieService;
import com.pi.seriesservice.domain.entity.Serie;
import com.pi.seriesservice.domain.repository.SerieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService implements ISerieService {

    private SerieRepository serieRepository;

    public SerieService(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    @Override
    public void save(Serie serie) {
        serieRepository.save(serie);
    }

    @Override
    public List<Serie> findAllByGenre(String genre) {
        List<Serie> series = serieRepository.findAllByGenre(genre);
        return series;
    }
}
