CREATE TABLE movies (
    id SERIAL NOT NULL PRIMARY KEY,
    poster text NOT NULL,
    rating real NOT NULL default 0.0,
    budget int,
    title varchar(255) NOT NULL ,
    tagline varchar(255),
    description text,
    year date NOT NULL
)