package com.pi.catalogservice.api.service.impl;

import com.pi.catalogservice.domain.entity.Catalog;
import com.pi.catalogservice.domain.respository.CatalogRepository;
import com.pi.catalogservice.api.service.ICatalogService;
import org.springframework.stereotype.Service;


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
