package com.creations.bms.repository;

import com.creations.bms.models.locations.Location;
import com.creations.bms.models.users.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LocationRepository extends CrudRepository<Location, UUID> {
}
