package org.app.service;

import lombok.RequiredArgsConstructor;
import org.app.dto.request.MovieRequestDto;
import org.app.dto.response.MovieResponsetDto;
import org.app.exception.NotFoundException;
import org.app.mapper.MovieMapper;
import org.app.model.Genre;
import org.app.model.Movie;
import org.app.repository.GenreRepository;
import org.app.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final GenreRepository genreRepository;
    private final MovieMapper movieMapper;

    public List<MovieResponsetDto> getAllMovies() {

        List<Movie> movieList = movieRepository.findAll();
        List<MovieResponsetDto> movieResponsetDtoList = movieList.stream().map(movieMapper::toDto).toList();

        return movieResponsetDtoList;
    }

    public MovieResponsetDto getMovie(Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(()-> new NotFoundException(Movie.class.getSimpleName()));
        return movieMapper.toDto(movie);
    }

    public void createMovie(MovieRequestDto movieRequestDto) {
        Genre genre = genreRepository.findByName(movieRequestDto.getGenre().toLowerCase()).orElseThrow(() -> new NotFoundException(Genre.class.getSimpleName()));
        Movie movie = movieMapper.dtoToEntity(movieRequestDto);
        movieRepository.save(movie);
    }


}
