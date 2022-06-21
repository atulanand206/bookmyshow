package com.creations.bms.models.movies;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("movies")
public class Movie implements Persistable<UUID> {
    @Id
    @Column("id")
    @JsonProperty("id")
    private UUID id;

    @Column("name")
    @JsonProperty("name")
    private String name;

    @Column("duration")
    @JsonProperty("duration")
    private int duration;

    @Column("release_date")
    @JsonProperty("release_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Timestamp releaseDate;

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return true;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
