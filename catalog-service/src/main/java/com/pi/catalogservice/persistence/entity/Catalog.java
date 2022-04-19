package com.pi.catalogservice.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pi.catalogservice.persistence.dto.Movie;
import com.pi.catalogservice.persistence.dto.Serie;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter @Setter
@Document
@JsonIgnoreProperties(ignoreUnknown = true)
public class Catalog {
    private String genre;
    private List<Movie> movies;
    private List<Serie> series;
}
