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

INSERT INTO users (id, name, surname, date_created) VALUES (1, 'john', 'snow',     '2021-01-01 22:24:41.153796');
INSERT INTO users (id, name, surname, date_created) VALUES (2, 'mike', 'buchanan', '2021-01-02 13:04:54.476535');
INSERT INTO users (id, name, surname, date_created) VALUES (3, 'luke', 'skywalker', '2021-01-02 22:51:04.376425');

INSERT INTO films (id, title, year, tags, genres) VALUES (12345, 'The Matrix', 1999, 'artificial reality, computers, technology, hacker, post apocalypse', 'science-fiction, thriller, action');
INSERT INTO films (id, title, year, tags, genres) VALUES (45678, 'Star Wars. Episode IV: A new hope', 1977, 'space, galactic war, droids, rebellion', 'science-fiction, adventures, fantasy');
INSERT INTO films (id, title, year, tags, genres) VALUES (11111, 'Up', 2009, 'child, original story, balloon, south america', 'animation, adventures, comedy, family');

INSERT INTO ratings (user_id, film_id, rate) VALUES (1, 12345, 8);
INSERT INTO ratings (user_id, film_id, rate) VALUES (2, 12345, 9);
INSERT INTO ratings (user_id, film_id, rate) VALUES (3, 12345, 8);
INSERT INTO ratings (user_id, film_id, rate) VALUES (1, 45678, 7);
INSERT INTO ratings (user_id, film_id, rate) VALUES (1, 11111, 9);
INSERT INTO ratings (user_id, film_id, rate) VALUES (2, 11111, 9);
