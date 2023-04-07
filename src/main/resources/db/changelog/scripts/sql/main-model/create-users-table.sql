CREATE TABLE users
(
    id        SERIAL       NOT NULL PRIMARY KEY,
    nickname  varchar(255) NOT NULL UNIQUE,
    firstname varchar(255),
    surname   varchar(255),
    image_path varchar(255),
    email varchar(255) NOT NULL UNIQUE,
    country_id serial not null ,
    language_id serial NOT NULL,
    password  varchar(255) NOT NULL,
    foreign key (language_id) references languages(id),
    foreign key (country_id) references countries(id)
)