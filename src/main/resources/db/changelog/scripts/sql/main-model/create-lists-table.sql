CREATE TABLE lists (
    id SERIAL NOT NULL PRIMARY KEY,
    title varchar(255) NOT NULL,
    is_favourite BOOLEAN NOT NULL default false,
    user_id SERIAL NOT NULL,
    foreign key (user_id) references users(id)
)