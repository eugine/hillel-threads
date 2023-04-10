CREATE TABLE users
(
    id    INTEGER PRIMARY KEY,
    name  TEXT        NOT NULL,
    email TEXT UNIQUE NOT NULL
);

ALTER TABLE users
    ADD COLUMN phone TEXT;

DROP TABLE users;
