package com.pi.catalogservice.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Serie {
    private Long id;
    private String name;
    private String genre;
    private List<Season> seasons;
}
