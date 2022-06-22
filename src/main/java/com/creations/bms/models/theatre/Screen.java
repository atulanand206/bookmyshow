package com.creations.bms.models.theatre;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("screens")
public class Screen implements Persistable<UUID> {
  @Id
  @Column("id")
  @JsonProperty("id")
  private UUID id;

  @Column("screen_kind")
  @JsonProperty("screen_kind")
  private ScreenKind screenKind;

  @Column("screen_no")
  @JsonProperty("screen_no")
  private int screenNo;

  @Column("seats")
  @JsonProperty("seats")
  private List<Seat> seats;

  @Override
  public UUID getId() {
    return id;
  }

  @Override
  public boolean isNew() {
    return true;
  }
}
