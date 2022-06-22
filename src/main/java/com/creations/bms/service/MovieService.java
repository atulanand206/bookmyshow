package com.creations.bms.service;

import com.creations.bms.models.movies.Movie;
import com.creations.bms.repository.MovieRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

  @Autowired MovieRepository movieRepository;

  public Movie create(Movie movie) {
    movie.setId(UUID.randomUUID());
    return movieRepository.save(movie);
  }

  public List<Movie> getAll() {
    List<Movie> result = new ArrayList<>();
    movieRepository.findAll().iterator().forEachRemaining(result::add);
    return result;
  }

  public Movie getById(UUID movieId) {
    return movieRepository.findById(movieId).orElseThrow();
  }
}
