CREATE TABLE IF NOT EXISTS movies
(
  id            UUID         NOT NULL,
  name          VARCHAR(100) NOT NULL,
  duration      INTEGER      NOT NULL,
  release_date  TIMESTAMP    NOT NULL,
  CONSTRAINT movies_pkey PRIMARY KEY (id)
);