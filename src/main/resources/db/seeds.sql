DELETE FROM users;
INSERT INTO users(email, password_hash)
VALUES ('claudia.costa@codeforall.com', ''),
       ('david.cardoso@codeforall.com', '');

DELETE FROM passengers;
INSERT INTO passengers(national_id, first_name, last_name, birthdate, phone, email, user_id)
VALUES ('123456789EF', 'Cláudia', 'Costa', DATE '2001-01-01', '+351912345678', 'claudia.costa@codeforall.com', '2'),
       ('987654321AB', 'David', 'Cardoso', DATE '2001-01-01', '+351912345678', 'david.cardoso@codeforall.com', '1'),
       ('543219876CD', 'Bernard', 'Pineiro', DATE '2001-01-01', '+351912345678', 'bernard.pineiro@codeforall.com', '2');

DELETE FROM airports;
INSERT INTO airports (code, name, city, country, latitude, longitude)
VALUES ('JFK', 'John F. Kennedy International Airport', 'New York', 'United States', 40.6413, -73.7781),
       ('LHR', 'London Heathrow Airport', 'London', 'United Kingdom', 51.4694, -0.4543),
       ('CDG', 'Charles de Gaulle Airport', 'Paris', 'France', 49.0097, 2.5479),
       ('LIS', 'Humberto Delgado Airport', 'Lisbon', 'Portugal', 38.7800, -9.1350),
       ('PEK', 'Beijing Capital International Airport', 'Beijing', 'China', 40.0799, 116.6031),
       ('HND', 'Haneda Airport', 'Tokyo', 'Japan', 35.5494, 139.7798),
       ('SYD', 'Kingsford Smith Airport', 'Sydney', 'Australia', -33.9500, 151.1817),
       ('AKL', 'Auckland Airport', 'Auckland', 'New Zealand', -37.0089, 174.7864),
       ('CPT', 'Cape Town International Airport', 'Cape Town', 'South Africa', -33.9715, 18.6021),
       ('LAD', 'Luanda Airport', 'Luanda', 'Angola', -8.8479, 13.2353),
       ('TLV', 'Ben Gurion Airport', 'Tel Aviv', 'Israel', 32.0004, 34.8706),
       ('FCO', 'Fiumicino Airport', 'Rome', 'Italy', 41.8034, 12.2519),
       ('BER', 'Schonefeld Airport', 'Berlin', 'Germany', 41.8034, 12.2519),
       ('SVO', 'Sheremetyevo Alexander S. Pushkin International Airport', 'Moscow', 'Russia', 55.9736, 37.4125),
       ('WAW', 'Warsaw Chopin Airport', 'Warsaw', 'Poland', 52.1644, 20.9697),
       ('IEV', 'Igor Sikorsky Kyiv International Airport', 'Kiev', 'Ukraine', 50.4120, 30.4433),
       ('ZAG', 'Zagreb Franjo Tuđman Airport', 'Zagreb', 'Croatia', 45.7407, 16.0690),
       ('ATH', 'Athens International Airport', 'Athens', 'Greece', 37.9362, 23.9480),
       ('IST', 'Istanbul Airport', 'Istanbul', 'Turkey', 41.2592, 28.7428),
       ('VIE', 'Vienna Airport', 'Vienna', 'Austria', 48.1180, 16.5663),
       ('AMS', 'Amsterdam Airport Schiphol', 'Amsterdam', 'The Netherlands', 52.3130, 4.7725),
       ('BRU', 'Zaventem Airport', 'Brussels', 'Belgium', 50.9008, 4.4865),
       ('MAD', 'Barajas Airport', 'Madrid', 'Spain', 40.4895, -3.5643),
       ('BCN', 'El Prat Airport', 'Barcelona', 'Spain', 41.2980, 2.0799),
       ('OPO', 'Francisco Sa Carneiro Airport', 'Porto', 'Portugal', 41.2370, 8.6707),
       ('OSL', 'Oslo Airport', 'Oslo', 'Norway', 60.1979, 11.0964),
       ('ARN', 'Arlanda Airport', 'Stockholm', 'Sweden', 59.6443, 17.9282),
       ('HEL', 'Vantaa Airport', 'Helsinki', 'Finland', 60.3179, 24.9496),
       ('BEG', 'Nikola Tesla Airport', 'Belgrade', 'Sebria', 44.8196, 20.2901),
       ('CPH', 'Copenhagen Airport', 'Copenhagen', 'Denmark', 55.6120, 12.6478),
       ('FRA', 'Frankfurt Airport', 'Frankfurt', 'Germany', 50.0380, 8.5622),
       ('CAI', 'Cairo International Airport', 'Cairo', 'Egypt', 30.1119, 31.4007),
       ('LOS', 'Murtala Muhammed International Airport', 'Lagos', 'Nigeria', 6.6018, 3.3515),
       ('CMN', 'Casablanca Mohammed V International Airport', 'Casablanca', 'Morocco', 33.3700, -7.5845),
       ('HAN', 'Noi Bai International Airport', 'Hanoi', 'Vietnam', 21.2176, 105.7930),
       ('ULN', 'Buyant Ukhaa International Airport', 'Ulaanbataar', 'Mongolia', 47.8495, 106.7673),
       ('PVG', 'Shanghai Pudong International Airport', 'Shanghai', 'China', 31.1443, 121.8083),
       ('MFM', 'Macau International Airport', 'Macau', 'China', 22.1554, 113.5875),
       ('LAX', 'Los Angeles International Airport', 'Los Angeles', 'United States', 33.9438, -118.4091),
       ('ORD', 'OHare International Airport', 'Chicago', 'United States', 41.9802, -87.9090),
       ('ATL', 'Hartsfield-Jackson Atlanta International Airport', 'Atlanta', 'United States', 33.6361, -84.4294),
       ('MIA', 'Miami International Airport', 'Miami', 'United States', 25.7951, -80.2795),
       ('SEA', 'Seattle-Tacoma International Airport', 'Seattle', 'United States', 47.4484, -122.3086),
       ('DCA', 'Ronald Reagan Washington National Airport', 'Washington D.C.', 'United States', 38.8512, -77.0402),
       ('BOS', 'Boston Logan International Airport', 'Boston', 'United States', 42.3656, -71.0098),
       ('HNL', 'Daniel K. Inouye International Airport', 'Honolulu', 'United States', 21.3186, -157.9254),
       ('AWI', 'Wainwright Airport', 'Alaska-Wainwright', 'United States', 70.6372, -160.0001),
       ('SFO', 'San Francisco International Airport', 'San Francisco', 'United States', 37.6192, -122.3816),
       ('YYZ', 'Toronto Pearson International Airport', 'Toronto', 'Canada', 43.6817, -79.6145),
       ('MEX', 'Mexico City International Airport', 'Mexico City', 'Mexico', 19.4361, -99.0719),
       ('HAV', 'Jose Marti International Airport', 'Havana', 'Cuba', 22.5921, -82.2433),
       ('BOG', 'El Dorado International Airport', 'Bogota', 'Colombia', 4.7010, -74.1461),
       ('LIM', 'Jorge Chavez International Airport', 'Lima', 'Peru', -12.0230, -77.1080),
       ('GRU', 'Guarulhos International Airport', 'Sao Paulo', 'Brazil', -23.4262, -46.4800),
       ('GIG', 'Tom Jobim International Airport', 'Rio de Janeiro', 'Brazil', -22.8053, -43.2566),
       ('EZE', 'Ezeiza International Airport', 'Buenos Aires', 'Argentina', -34.8165, -58.5373),
       ('SCL', 'Arturo Merino Benitez International Airport', 'Santiago', 'Chile', -33.3973, -70.7937),
       ('SEZ', 'Seychelles International Airport', 'Seychelles', 'Seychelles', -4.6709, 55.5115),
       ('MLE', 'Velana International Airport', 'Maldives', 'Maldives', 4.1130, 73.3144),
       ('DEL', 'Indira Gandhi International Airport', 'New Dehli', 'India', 28.5567, 77.1006),
       ('BOM', 'Chhatrapati Shivaji Maharaj International Airport', 'Mumbai', 'India', 19.0975, 72.8747),
       ('MNL', 'Ninoy Aquino International Airport', 'Manila', 'The Philippines', 14.5123, 121.0165),
       ('KTM', 'Tribhuvan International Airport', 'Kathmandu', 'Nepal', 27.7001, 85.3568),
       ('KHI', 'Jinnah International Airport', 'Karachi', 'Pakistan', 24.9008, 67.1681),
       ('ISB', 'Islamabad International Airport', 'Islamabad', 'Pakistan', 33.5565, 72.8341),
       ('TBS', 'Tbilisi International Airport', 'Tbilisi', 'Georgia', 41.6698, 44.9644),
       ('WDH', 'Hosea Kutako International Airport', 'Windhoek', 'Namibia', -22.4871, 17.4631),
       ('DSS', 'Blaise Diagne International Airport', 'Dakar', 'Senegal', 14.6709, -17.0673),
       ('KIN', 'Norman Manley International Airport', 'Kingston', 'Jamaica', 17.9367, -76.7797),
       ('SJO', 'Juan Santamaria International Airport', 'San Jose', 'Costa Rica', 9.9979, -84.2040),
       ('PTY', 'Tocumen International Airport', 'Panama City', 'Panama', 9.0670, -79.3875),
       ('UIO', 'Mariscal Sucre Quito International Airport', 'Quito', 'Ecuador', -0.1242, -78.3606),
       ('BSB', 'President Juscelino Kubitschek International Airport', 'Brasilia', 'Brazil', -15.8707, -47.9193),
       ('LPB', 'El Alto International Airport', 'La Paz', 'Bolivia', -16.5104, -68.1882),
       ('MVD', 'Carrasco International Airport', 'Montevideo', 'Uruguay', -34.8371, -56.0162),
       ('ASU', 'Silvio Pettirossi International Airport', 'Asuncion', 'Paraguay', -25.2417, -57.5140),
       ('KUL', 'Kuala Lumpur International Airport', 'Kuala Lumpur', 'Malaysia', 2.7542, 101.7043),
       ('BKK', 'Suvarnabhumi Airport', 'Bangkok', 'Thailand', 13.6819, 100.7469),
       ('SIN', 'Singapore Changi Airport', 'Singapore', 'Singapore', 1.3545, 103.9886),
       ('ICN', 'Incheon International Airport', 'Seoul', 'South Korea', 37.4493, 126.4513),
       ('HKG', 'Hong Kong International Airport', 'Hong Kong', 'China', 22.3135, 113.9137),
       ('CGK', 'Soekarno–Hatta International Airport', 'Jakarta', 'Indonesia', -6.1264, 106.6547),
       ('GYD', 'Heydar Aliyev International Airport', 'Baku', 'Azerbaijan', 40.4656, 50.0521),
       ('SJJ', 'Sarajevo International Airport', 'Sarajevo', 'Bosnia and Herzegovina', 43.8262, 18.3368),
       ('ZRH', 'Zurich Airport', 'Zurich', 'Switzerland', 47.4617, 8.5509),
       ('BUD', 'Ferenc Liszt International Airport', 'Budapest', 'Hungary', 47.4329, 19.2608),
       ('PRG', 'Vaclav Havel Airport Prague', 'Prague', 'Czechia', 50.1018, 14.2632),
       ('RKV', 'Reykjavik Domestic Airport', 'Reykjavik', 'Iceland', 64.1318, -21.9466),
       ('DUB', 'Dublin Airport', 'Dublin', 'Ireland', 53.4268, -6.2562),
       ('OTP', 'Henri Coanda International Airport', 'Bucharest', 'Romania', 44.4268, 26.1025),
       ('BTS', 'M. R. Stefanik Airport Bratislava', 'Bratislava', 'Slovakia', 48.1697, 17.1996),
       ('LJU', 'Joze Pucnik Airport', 'Ljubljana', 'Slovenia', 46.2286, 14.4542),
       ('BOB', 'Bora Bora Airport', 'Bora Bora', 'French Polynesia', -16.4442, -151.7516),
       ('LED', 'Pulkovo Airport', 'Saint Petersburg', 'Russia', 59.8029, 30.2678),
       ('ZNZ', 'Abeid Amani Karume International Airport', 'Zanzibar', 'Zanzibar', -6.2185, 39.2214),
       ('JNB', 'O.R. Tambo International Airport', 'Johannesburg', 'South Africa', -26.1371, 28.2416),
       ('RUH', 'King Khalid International Airport', 'Riyadh', 'Saudi Arabia', 24.9596, 46.7024),
       ('DXB', 'Dubai International Airport', 'Dubai', 'U.A.E', 25.2566, 55.3641),
       ('AUH', 'Abu Dhabi International Airport', 'Abu Dhabi', 'U.A.E', 24.4419, 54.6501),
       ('PER', 'Perth Airport', 'Perth', 'Australia', -31.9385, 115.9672),
       ('DFW', 'Fort Worth International Airport', 'Dallas', 'United States', 32.8998, -97.0403);

DELETE FROM flights;
INSERT INTO flights(code, carrier, origin_airport_code, destination_airport_code, departure_time, duration)
-- Used TIMESTAMPADD instead of DATE_ADD for dev purposes since DATE_ADD is not compatible with h2
VALUES ('BA0499', 'British Airways', 'LIS', 'BER', TIMESTAMPADD(DAY, 2, CURRENT_TIMESTAMP()), '180'),
       ('TP0538', 'TAP Air Portugal', 'LIS', 'LHR', TIMESTAMPADD(DAY, 1, CURRENT_TIMESTAMP()), '210');

DELETE FROM tickets;
INSERT INTO tickets(passenger_id, flight_code, cabin_class, price, cabin_bags, checked_bags)
VALUES (1, 'BA0499', 'ECONOMY', '393', '1', '0'),
       (2, 'TP0538', 'PREMIUM_ECONOMY', '430', '1', '1'),
       (2, 'BA0499', 'FIRST', '1570', '1', '2');