DROP DATABASE IF EXISTS final_call;
CREATE DATABASE final_call;

DROP TABLE IF EXISTS passengers;
CREATE TABLE passengers (
    national_id VARCHAR(30) UNIQUE NOT NULL PRIMARY KEY,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    dob DATETIME NOT NULL,
    phone VARCHAR(30),
    email VARCHAR(40) NOT NULL
);

DROP TABLE IF EXISTS tickets;
CREATE TABLE tickets (
    passenger_national_id VARCHAR(30) NOT NULL PRIMARY KEY,
    flight_code VARCHAR(30) NOT NULL PRIMARY KEY,
    cabin_class VARCHAR(30) NOT NULL,
    price DOUBLE NOT NULL,
    seat VARCHAR(30),
    cabin_bags INT,
    carry_on_bags INT,
    FOREIGN KEY (passenger_national_id) REFERENCES passengers(national_id),
    FOREIGN KEY (flight_code) REFERENCES flights(code)
);

DROP TABLE IF EXISTS flights;
CREATE TABLE flights(
    code VARCHAR(30) UNIQUE NOT NULL PRIMARY KEY,
    carrier VARCHAR(30) NOT NULL,
    departure_airport_code INT NOT NULL,
    destination_airport_code INT NOT NULL,
    departure_time DATETIME NOT NULL,
    duration INT NOT NULL,
    FOREIGN KEY (departure_airport_code) REFERENCES airports(code),
    FOREIGN KEY (destination_airport_code) REFERENCES airports(code)
);

DROP TABLE IF EXISTS airports;
CREATE TABLE airports (
    code VARCHAR(30) UNIQUE NOT NULL PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    city VARCHAR(30) NOT NULL,
    country VARCHAR(30) NOT NULL,
    latitude DOUBLE NOT NULL,
    longitude DOUBLE NOT NULL
);