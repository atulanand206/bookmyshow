package com.creations.bms.models.theatre;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.UUID;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "seat_type")
@Entity
public class SeatType implements Persistable<UUID>, Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  @JsonProperty("id")
  private UUID id;

  @Column(name = "tag")
  @JsonProperty("tag")
  private String tag;

  @Column(name = "seat_kind")
  @JsonProperty("seat_kind")
  private String seatKind;

  @Column(name = "seat_count")
  @JsonProperty("seat_count")
  private int seatCount;

  @Column(name = "price")
  @JsonProperty("price")
  private int price;

  @Override
  public boolean isNew() {
    return true;
  }
}
