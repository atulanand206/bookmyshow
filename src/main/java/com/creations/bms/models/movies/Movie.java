package com.creations.bms.models.movies;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Timestamp;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movies")
public class Movie implements Persistable<UUID> {
  @Id
  @Column(name = "id")
  @JsonProperty("id")
  private UUID id;

  @Column(name = "name")
  @JsonProperty("name")
  private String name;

  @Column(name = "duration")
  @JsonProperty("duration")
  private int duration;

  @Column(name = "release_date")
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
