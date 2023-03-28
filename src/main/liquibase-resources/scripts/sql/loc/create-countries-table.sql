CREATE TABLE countries(
    id serial not null primary key ,
    name varchar(255) not null unique
)