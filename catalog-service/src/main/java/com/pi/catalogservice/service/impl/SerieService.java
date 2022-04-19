package com.pi.catalogservice.service.impl;

import com.pi.catalogservice.persistence.dto.Serie;
import com.pi.catalogservice.persistence.entity.Catalog;
import com.pi.catalogservice.persistence.respository.CatalogRepository;
import com.pi.catalogservice.persistence.respository.feign.SerieFeignRepository;
import com.pi.catalogservice.service.ISerieService;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SerieService implements ISerieService {
    private SerieFeignRepository serieFeignRepository;
    private CatalogRepository catalogRepository;

    public SerieService(SerieFeignRepository serieFeignRepository, CatalogRepository catalogRepository) {
        this.serieFeignRepository = serieFeignRepository;
        this.catalogRepository = catalogRepository;
    }

    @CircuitBreaker(name = "series", fallbackMethod = "getAllCatalogFallbackMethod")
    @Retry(name = "series")
    @Override
    public void save(Serie serie) {
        log.info("Calling series-service..." );
        serieFeignRepository.save(serie);
    }

    List<Catalog> getAllCatalogFallbackMethod(CallNotPermittedException exception){
        return catalogRepository.findAll();
    }
}
