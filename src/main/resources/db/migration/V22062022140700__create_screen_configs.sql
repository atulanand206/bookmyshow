CREATE TABLE IF NOT EXISTS screen_config
(
  id            UUID         NOT NULL,
  tag           VARCHAR(30)  NOT NULL,
  CONSTRAINT screen_configs_pkey PRIMARY KEY (id)
);