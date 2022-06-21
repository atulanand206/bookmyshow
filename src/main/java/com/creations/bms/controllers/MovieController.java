package com.creations.bms.controllers;

import com.creations.bms.models.movies.Movie;
import com.creations.bms.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/movies/")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("")
    public Movie createMovie(@RequestBody Movie movieDto) {
        return movieService.create(movieDto);
    }

    @GetMapping("")
    public List<Movie> getAll() {
        return movieService.getAll();
    }

    @GetMapping("{movieId}")
    public Movie getMovie(UUID movieId) {
        return movieService.getById(movieId);
    }
}
