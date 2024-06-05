# Final Call (WIP)

Check-in platform that allows you to book your last minute trip. 
You will be able to create an account, check the next flight available from your selected airport and book it.
Your data will be saved in our database and the flights will be generated using real time information on real flights.

Get ready to book your last minute flight with Final Call!

## How to Run

To run this project, you'll need:
- JDK 1.8
- Maven 3
- Tomcat 9
- MySQL 8

Get started:
- Clone this repository;
- Make sure the database and server properties* match your local configuration.
- Build and deploy the project by running `mvn tomcat7:deploy`;
- Use Postman to make requests to the endpoints listed bellow.

**These properties can be found in `pom.xml` and `main/resources/finalcall.properties`.*

## API Endpoints

### Users
| **Action** | **Endpoint**   | **Description**        |
|------------|----------------|------------------------|
| GET        | /api/user      | List all users.        |
| GET        | /api/user/{id} | Show a specific user.  |
| POST       | /api/user/     | Add a new user.        |
| PUT        | /api/user/{id} | Edit an existing user. |
| DELETE     | /api/user/{id} | Delete a user.         |

### Passengers
| **Action** | **Endpoint**                      | **Description**                          |
|------------|-----------------------------------|------------------------------------------|
| GET        | /api/user/{userId}/passenger      | List all passengers for a specific user. |
| GET        | /api/user/{userId}/passenger/{id} | Show a specific passenger.               |
| POST       | /api/user/{userId}/passenger/     | Add a new passenger.                     |
| PUT        | /api/user/{userId}/passenger/{id} | Edit an existing passenger.              |
| DELETE     | /api/user/{userId}/passenger/{id} | Delete a passenger.                      |

### Bookings
| **Action** | **Endpoint**                    | **Description**    |
|------------|---------------------------------|--------------------|
| GET        | /api/user/{userId}/booking/{id} | Show a booking.    |
| POST       | /api/user/{userId}/booking/     | Add a new booking. |

### Airports
| **Action** | **Endpoint**                   | **Description**                                              |
|------------|--------------------------------|--------------------------------------------------------------|
| GET        | /api/airport                   | List all airports.                                           |
| GET        | /api/airport/{id}              | Show a specific airport.                                     |
| GET        | /api/airport/{id}/destinations | Show available airport destinations from a specific airport. |

### Flights
| **Action** | **Endpoint**                          | **Description**                                                                                                                                                   |
|------------|---------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| GET        | /api/flight/{id}                      | Show a specific flight.                                                                                                                                           |
| GET        | /api/flight/select?origin={airportId} | Show the flight with the soonest departure from a specific airport to any destination. Use the optional `destination` parameter to specify a destination airport. |
| POST       | /api/flight/                          | Add a new flight.                                                                                                                                                 |
| PUT        | /api/flight/{id}                      | Edit an existing flight.                                                                                                                                          |
| DELETE     | /api/flight/{id}                      | Delete a flight.                                                                                                                                                  |

## Technology Stack

- Javascript
- HTML5
- CSS3
- JSON
- Jackson (JSON library)
- Tomcat
- Java
- Spring
- Hibernate ORM
- SQL
- MySQL
- Maven
- JUnit
- Mockito