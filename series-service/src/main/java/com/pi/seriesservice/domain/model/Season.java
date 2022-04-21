package com.pi.seriesservice.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Season {
    private Long id;
    private Integer seasonNumber;
    private List<Chapter> chapters;
}
