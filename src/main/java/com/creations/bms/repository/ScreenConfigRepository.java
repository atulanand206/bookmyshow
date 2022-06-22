package com.creations.bms.repository;

import com.creations.bms.models.theatre.ScreenConfig;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenConfigRepository extends CrudRepository<ScreenConfig, UUID> {}
