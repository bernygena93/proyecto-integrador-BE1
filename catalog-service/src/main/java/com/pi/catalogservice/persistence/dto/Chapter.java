package com.pi.catalogservice.persistence.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Chapter {
    private Long id;
    private String name;
    private Integer number;
    private String urlStream;
}
