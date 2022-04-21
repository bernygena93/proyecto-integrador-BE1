package com.pi.seriesservice.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Chapter {
    private Long id;
    private String name;
    private Integer number;
    private String urlStream;

}
