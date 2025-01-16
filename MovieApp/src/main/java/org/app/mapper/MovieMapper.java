package org.app.mapper;

import org.app.dto.request.MovieRequestDto;
import org.app.dto.response.MovieResponsetDto;
import org.app.model.Movie;
import org.mapstruct.Mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE)
public interface MovieMapper {

    MovieResponsetDto toDto(Movie movie);
    Movie dtoToEntity(MovieRequestDto dto);

}
