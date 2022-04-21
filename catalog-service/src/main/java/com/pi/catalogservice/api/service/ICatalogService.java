package com.pi.catalogservice.api.service;

import com.pi.catalogservice.domain.entity.Catalog;


public interface ICatalogService {
    Catalog findByGenre(String genre);
}
