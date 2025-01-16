package org.app.controller;

import lombok.RequiredArgsConstructor;
import org.app.dto.response.MovieResponsetDto;
import org.app.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieResponsetDto>> getAllMovies() {
       List<MovieResponsetDto> movieResponsetDtoList = movieService.getAllMovies();
       return ResponseEntity.ok().body(movieResponsetDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponsetDto> getMovie(@PathVariable Long id) {
        MovieResponsetDto movie = movieService.getMovie(id);
        return ResponseEntity.ok().body(movie);
    }






}
