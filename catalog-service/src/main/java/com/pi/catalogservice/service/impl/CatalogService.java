package com.pi.catalogservice.service.impl;

import com.pi.catalogservice.persistence.entity.Catalog;
import com.pi.catalogservice.persistence.respository.CatalogRepository;
import com.pi.catalogservice.service.ICatalogService;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

}
