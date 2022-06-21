CREATE TABLE IF NOT EXISTS locations
(
  id            UUID         NOT NULL,
  name          VARCHAR(100) NOT NULL,
  CONSTRAINT locations_pkey PRIMARY KEY (id)
);