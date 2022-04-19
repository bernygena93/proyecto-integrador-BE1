package com.pi.seriesservice.persistence.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Season {
    private Long id;
    private Integer seasonNumber;
    private List<Chapter> chapters;
}
