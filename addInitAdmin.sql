INSERT INTO roles(id, roles)
VALUES (1, 'ADMIN'), (2, 'USER');

INSERT INTO users(id, age, email, password, username)
VALUES (1, 20, 'admin@gmail.com', '$2a$08$3rfZfoJPY18TgTw3W/Zg9.r4bzQ1OUTmaGKt0lfcG8njZCQ.yI1ym', 'admin');

INSERT INTO user_role(user_id, role_id)
VALUES (1, 1), (1,2);