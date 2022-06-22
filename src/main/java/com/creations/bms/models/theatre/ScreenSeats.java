package com.creations.bms.models.theatre;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "screen_seats")
@Entity
public class ScreenSeats implements Persistable<UUID> {

  @Id
  @Column(name = "id")
  @JsonProperty("id")
  private UUID id;

  @Column(name = "screen_config_id")
  @JsonProperty("screen_config_id")
  private UUID screenConfigId;

  @Column(name = "seat_type_id")
  @JsonProperty("seat_type_id")
  private UUID seatTypeId;

  @Override
  public UUID getId() {
    return id;
  }

  @Override
  public boolean isNew() {
    return false;
  }
}
