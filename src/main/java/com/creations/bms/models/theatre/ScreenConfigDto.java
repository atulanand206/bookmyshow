package com.creations.bms.models.theatre;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScreenConfigDto implements Serializable {

  @JsonProperty("id")
  private UUID id;

  @JsonProperty("tag")
  private String tag;

  @JsonProperty("configs")
  private List<SeatType> configs;
}
