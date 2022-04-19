package com.pi.seriesservice.service.impl;

import com.pi.seriesservice.persistence.entity.Serie;
import com.pi.seriesservice.persistence.repository.SerieRepository;
import com.pi.seriesservice.service.ISerieService;
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
