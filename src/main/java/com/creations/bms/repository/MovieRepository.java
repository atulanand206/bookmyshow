package com.creations.bms.repository;

import com.creations.bms.models.movies.Movie;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, UUID> {}
