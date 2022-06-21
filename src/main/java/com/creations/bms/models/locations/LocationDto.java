package com.creations.bms.models.locations;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LocationDto {

    @JsonProperty("name")
    String name;

    LocationDto() {

    }

    LocationDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
