package com.creations.bms.models.locations;

import static com.creations.bms.Preconditions.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("locations")
public class Location implements Persistable<UUID> {

  @Id
  @Column("id")
  @JsonProperty("id")
  private UUID id;

  @Column("name")
  @JsonProperty("name")
  private String name;

  public Location() {}

  /**
   * @param id the id of the location.
   * @param name the name of the location.
   * @throws IllegalArgumentException in any of the following fails to be conformant:
   */
  public Location(UUID id, String name) throws IllegalArgumentException {
    validateNotNull(id);
    validateNotNull(name);
    this.id = id;
    this.name = name;
  }

  public UUID getId() {
    return id;
  }

  @Override
  public boolean isNew() {
    return true;
  }

  public String getName() {
    return name;
  }
}
