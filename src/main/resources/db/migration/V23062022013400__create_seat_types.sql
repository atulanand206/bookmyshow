CREATE TABLE IF NOT EXISTS seat_type
(
  id            UUID         NOT NULL,
  tag           VARCHAR(30)  NOT NULL,
  seat_kind     VARCHAR(10)  NOT NULL,
  seat_count    INTEGER      NOT NULL,
  price         INTEGER      NOT NULL,
  CONSTRAINT stidpk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS screen_seats
(
  id                UUID    NOT NULL,
  screen_config_id  UUID    NOT NULL,
  seat_type_id      UUID    NOT NULL,
  CONSTRAINT sspk PRIMARY KEY (id),
  CONSTRAINT ssidfk FOREIGN KEY(screen_config_id)
        REFERENCES screen_config(id),
  CONSTRAINT sstidfk FOREIGN KEY(seat_type_id)
        REFERENCES seat_type(id)
);