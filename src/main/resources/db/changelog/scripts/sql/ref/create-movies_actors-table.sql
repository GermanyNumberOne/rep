CREATE TABLE movies_actors (
    movie_id SERIAL NOT NULL ,
    actor_id SERIAL NOT NULL ,
    primary key (movie_id, actor_id),
    foreign key (movie_id) references movies(id),
    foreign key (actor_id) references actors(id)
)