package com.creations.bms.service;

import com.creations.bms.models.locations.Location;
import com.creations.bms.models.locations.LocationDto;
import com.creations.bms.repository.LocationRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

  @Autowired LocationRepository locationRepository;

  public Location create(LocationDto locationDto) {
    Location location = new Location(UUID.randomUUID(), locationDto.getName());
    return locationRepository.save(location);
  }

  public List<Location> getAll() {
    List<Location> result = new ArrayList<>();
    locationRepository.findAll().iterator().forEachRemaining(result::add);
    return result;
  }

  public Location get(UUID locationId) {
    return locationRepository.findById(locationId).orElseThrow();
  }
}
