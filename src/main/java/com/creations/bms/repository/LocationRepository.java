package com.creations.bms.repository;

import com.creations.bms.models.locations.Location;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository<Location, UUID> {}
