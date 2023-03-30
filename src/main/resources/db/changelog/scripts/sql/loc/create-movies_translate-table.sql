CREATE TABLE movietr (
    id SERIAL NOT NULL PRIMARY KEY ,
    title varchar(255) NOT NULL ,
    description text NOT NULL ,
    tagline varchar(255),
    movie_id SERIAL NOT NULL ,
    language_id SERIAL NOT NULL ,
    foreign key (movie_id) references movies(id),
    foreign key (language_id) references languages(id)
)