CREATE TABLE actortr (
    id SERIAL NOT NULL PRIMARY KEY,
    firstname varchar(255) NOT NULL ,
    surname varchar(255) NOT NULL ,
    actor_id SERIAL NOT NULL ,
    language_id SERIAL NOT NULL ,
    foreign key (actor_id) references actors(id),
    foreign key (language_id) references languages(id)
)