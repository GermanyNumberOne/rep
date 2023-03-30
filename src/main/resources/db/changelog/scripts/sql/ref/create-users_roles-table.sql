CREATE TABLE users_roles
(
    user_id SERIAL NOT NULL,
    role_id SERIAL NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (role_id) REFERENCES roles (id),
    PRIMARY KEY (user_id, role_id)
)