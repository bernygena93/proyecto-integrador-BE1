package com.pi.catalogservice.persistence.respository;

import com.pi.catalogservice.persistence.entity.Catalog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepository extends MongoRepository<Catalog, Long> {
    Catalog findByGenre(String genre);
}
