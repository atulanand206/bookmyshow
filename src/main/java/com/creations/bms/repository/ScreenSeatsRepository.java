package com.creations.bms.repository;

import com.creations.bms.models.theatre.ScreenSeats;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenSeatsRepository extends CrudRepository<ScreenSeats, UUID> {

  Iterable<ScreenSeats> findAllByScreenConfigId(UUID screenConfigId);

  Optional<ScreenSeats> findBySeatTypeId(UUID seatTypeId);
}
