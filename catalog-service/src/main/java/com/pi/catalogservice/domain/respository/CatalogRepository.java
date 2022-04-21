package com.pi.catalogservice.domain.respository;

import com.pi.catalogservice.domain.entity.Catalog;
import com.pi.catalogservice.domain.model.Movie;
import com.pi.catalogservice.domain.model.Serie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepository extends MongoRepository<Catalog, Long> {
    Catalog findByGenre(String genre);
}
