package com.creations.bms.models.theatre;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "screen_config")
public class ScreenConfig implements Persistable<UUID>, Serializable {

  @Id
  @Column(name = "id")
  @JsonProperty("id")
  private UUID id;

  @Column(name = "tag")
  @JsonProperty("tag")
  private String tag;

  @Override
  public UUID getId() {
    return id;
  }

  @Override
  public boolean isNew() {
    return true;
  }
}
