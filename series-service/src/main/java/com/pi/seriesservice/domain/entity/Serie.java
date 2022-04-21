package com.pi.seriesservice.domain.entity;

import com.pi.seriesservice.domain.model.Season;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter @Setter
@Document(collection = "series")
public class Serie {
    @Id
    private Long id;
    private String name;
    private String genre;
    private List<Season> seasons;
}
