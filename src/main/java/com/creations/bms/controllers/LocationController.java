package com.creations.bms.controllers;

import com.creations.bms.models.locations.Location;
import com.creations.bms.models.locations.LocationDto;
import com.creations.bms.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/locations")
public class LocationController {

    @Autowired
    LocationService locationService;

    @PostMapping("/")
    public Location createLocation(@RequestBody LocationDto locationDto) {
        return locationService.create(locationDto);
    }

    @GetMapping("/")
    public List<Location> getLocations() {
        return locationService.getAll();
    }

    @GetMapping("/{locationId}")
    public Location getLocation(@RequestParam UUID locationId) {
        return locationService.get(locationId);
    }
}
