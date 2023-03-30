CREATE TABLE genretr (
    id SERIAL NOT NULL PRIMARY KEY ,
    name varchar(255) NOT NULL ,
    genre_id SERIAL NOT NULL ,
    language_id SERIAL NOT NULL ,
    foreign key (genre_id) references genres(id),
    foreign key (language_id) references languages(id)
)