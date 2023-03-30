CREATE TABLE roles
(
    id        SERIAL       NOT NULL PRIMARY KEY,
    name  varchar(255) NOT NULL UNIQUE
)