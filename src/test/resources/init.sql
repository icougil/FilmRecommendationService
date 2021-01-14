create table films
(
    id     integer primary key,
    title  varchar(50)  not null,
    year   integer,
    tags   varchar(255) not null,
    genres varchar(255) not null
);

create table users
(
    id integer not null primary key,
    name varchar(50) not null,
    surname varchar(150) not null,
    date_created timestamp default CURRENT_TIMESTAMP
);

create table ratings
(
    user_id integer not null references users,
    film_id integer not null references films,
    rate    integer not null,
    primary key (user_id, film_id)
);

INSERT INTO users (id, name, surname, date_created) VALUES (1, 'john', 'nieve',     '2021-01-01 22:24:41.153796');
INSERT INTO users (id, name, surname, date_created) VALUES (2, 'mike', 'pi',        '2021-01-02 13:04:54.476535');
INSERT INTO users (id, name, surname, date_created) VALUES (3, 'luke', 'skywalker', '2021-01-02 22:51:04.376425');

INSERT INTO films (id, title, year, tags, genres) VALUES (1, 'example', 2020, 'thriller, don''t know, science-fiction', 'adventure');
INSERT INTO films (id, title, year, tags, genres) VALUES (2, 'another', 1954, 'who knows', 'drama');

INSERT INTO ratings (user_id, film_id, rate) VALUES (1, 1, 8);
INSERT INTO ratings (user_id, film_id, rate) VALUES (2, 1, 8);
INSERT INTO ratings (user_id, film_id, rate) VALUES (3, 1, 8);
INSERT INTO ratings (user_id, film_id, rate) VALUES (1, 2, 6);
INSERT INTO ratings (user_id, film_id, rate) VALUES (3, 2, 7);
