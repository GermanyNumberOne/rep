CREATE TABLE comments (
    id SERIAL NOT NULL  PRIMARY KEY,
    content text NOT NULL,
    user_id SERIAL NOT NULL,
    movie_id SERIAL NOT NULL ,
    foreign key (user_id) references users(id),
    foreign key (movie_id) references movies(id)
)