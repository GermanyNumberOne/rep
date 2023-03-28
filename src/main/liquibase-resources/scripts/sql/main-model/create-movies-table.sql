CREATE TABLE movies (
    id SERIAL NOT NULL PRIMARY KEY,
    poster text NOT NULL,
    rating real NOT NULL default 0.0,
    budget int,
    year date NOT NULL
)