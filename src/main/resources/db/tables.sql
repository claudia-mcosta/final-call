DROP DATABASE IF EXISTS final_call;
CREATE DATABASE final_call;
USE final_call;

CREATE TABLE users (
    id              INT NOT NULL AUTO_INCREMENT,
    email           VARCHAR(30) NOT NULL UNIQUE,
    password_hash   VARCHAR(30) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE passengers (
    id              INT NOT NULL AUTO_INCREMENT,
    national_id     VARCHAR(30),
    first_name      VARCHAR(30) NOT NULL,
    last_name       VARCHAR(30) NOT NULL,
    birthdate       DATE        NOT NULL,
    phone           VARCHAR(30),
    email           VARCHAR(40) NOT NULL,
    user_id         INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE airports (
    code      VARCHAR(30),
    name      VARCHAR(60) NOT NULL,
    city      VARCHAR(30) NOT NULL,
    country   VARCHAR(30) NOT NULL,
    latitude  DOUBLE      NOT NULL,
    longitude DOUBLE      NOT NULL,
    PRIMARY KEY (code)
);

CREATE TABLE flights (
    code                     VARCHAR(30),
    carrier                  VARCHAR(30) NOT NULL,
    origin_airport_code      VARCHAR(30) NOT NULL,
    destination_airport_code VARCHAR(30) NOT NULL,
    departure_time           DATETIME    NOT NULL,
    duration                 INT         NOT NULL,
    PRIMARY KEY (code),
    FOREIGN KEY (origin_airport_code) REFERENCES airports (code),
    FOREIGN KEY (destination_airport_code) REFERENCES airports (code)
);

CREATE TABLE tickets (
    passenger_id          INT,
    flight_code           VARCHAR(30),
    cabin_class           VARCHAR(30) NOT NULL,
    price                 DOUBLE      NOT NULL,
    seat                  VARCHAR(30),
    cabin_bags            INT         NOT NULL,
    checked_bags          INT         NOT NULL,
    PRIMARY KEY (passenger_id, flight_code),
    FOREIGN KEY (passenger_id) REFERENCES passengers (id) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (flight_code) REFERENCES flights (code) ON UPDATE CASCADE ON DELETE CASCADE
);