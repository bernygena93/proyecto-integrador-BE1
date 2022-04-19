package com.pi.catalogservice.service;

import com.pi.catalogservice.persistence.entity.Catalog;


public interface ICatalogService {
    Catalog findByGenre(String genre);
}
