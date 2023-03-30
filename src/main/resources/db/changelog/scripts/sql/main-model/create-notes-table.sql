CREATE TABLE notes (
    id SERIAL NOT NULL PRIMARY KEY,
    user_id SERIAL NOT NULL,
    movie_id SERIAL NOT NULL ,
    comment text,
    rating real NOT NULL default 0.0,
    image text,
    foreign key (user_id) references users(id)
)