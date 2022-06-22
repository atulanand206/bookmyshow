package com.creations.bms.models.theatre;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Seat {
  @JsonProperty("seat_no")
  private int seatNo;

  @JsonProperty("seat_type")
  private SeatKind seatKind;
}
