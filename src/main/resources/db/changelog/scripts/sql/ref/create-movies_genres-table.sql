CREATE TABLE movies_genres (
    movie_id SERIAL NOT NULL ,
    genre_id SERIAL NOT NULL ,
    PRIMARY KEY (movie_id, genre_id),
    foreign key (movie_id) references movies(id),
    foreign key (genre_id) references genres(id)
)