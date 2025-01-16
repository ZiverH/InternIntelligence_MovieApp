package org.app.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MovieRequestDto {

    private String title;
    private String director;
    private String year;
    private String genre;
    private String imdb;
}
