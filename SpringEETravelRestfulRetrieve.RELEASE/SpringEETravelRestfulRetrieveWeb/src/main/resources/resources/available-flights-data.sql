
delete from available_flights;

insert into available_flights (id, departure_airport_code, departure_time, arrival_airport_code, arrival_time, airline, airline_code, airline_flight_number, class_of_service, price)  
values (NULL, 'DEN', TIMESTAMP ( '2012-03-22', '07:00:00' ), 'JFK', TIMESTAMP ( '2012-03-22', '09:30:00' ), 'American Airlines', 'AA', 'UA2833', 'Economy', 253.20);
insert into available_flights (id, departure_airport_code, departure_time, arrival_airport_code, arrival_time, airline, airline_code, airline_flight_number, class_of_service, price)  
values (NULL, 'DEN', TIMESTAMP ( '2012-03-22', '09:30:00' ), 'JFK', TIMESTAMP ( '2012-03-22', '11:30:00' ), 'American Airlines', 'AA', 'UA1772', 'Economy', 217.10);
insert into available_flights (id, departure_airport_code, departure_time, arrival_airport_code, arrival_time, airline, airline_code, airline_flight_number, class_of_service, price)  
values (NULL, 'DEN', TIMESTAMP ( '2012-03-22', '11:00:00' ), 'JFK', TIMESTAMP ( '2012-03-22', '14:30:00' ), 'American Airlines', 'AA', 'AA3824', 'Economy', 212.20);
insert into available_flights (id, departure_airport_code, departure_time, arrival_airport_code, arrival_time, airline, airline_code, airline_flight_number, class_of_service, price)  
values (NULL, 'DEN', TIMESTAMP ( '2012-03-22', '14:00:00' ), 'JFK', TIMESTAMP ( '2012-03-22', '16:30:00' ), 'American Airlines', 'AA', 'AA2727', 'Economy', 280.10);

insert into available_flights (id, departure_airport_code, departure_time, arrival_airport_code, arrival_time, airline, airline_code, airline_flight_number, class_of_service, price)  
values (NULL, 'JFK', TIMESTAMP ( '2012-03-26', '07:00:00' ), 'DEN', TIMESTAMP ( '2012-03-22', '09:30:00' ), 'American Airlines', 'AA', 'AA5432', 'Economy', 280.20);
insert into available_flights (id, departure_airport_code, departure_time, arrival_airport_code, arrival_time, airline, airline_code, airline_flight_number, class_of_service, price)  
values (NULL, 'JFK', TIMESTAMP ( '2012-03-26', '09:30:00' ), 'DEN', TIMESTAMP ( '2012-03-22', '11:30:00' ), 'American Airlines', 'AA', 'AA6784', 'Economy', 317.10);
insert into available_flights (id, departure_airport_code, departure_time, arrival_airport_code, arrival_time, airline, airline_code, airline_flight_number, class_of_service, price)  
values (NULL, 'JFK', TIMESTAMP ( '2012-03-26', '11:00:00' ), 'DEN', TIMESTAMP ( '2012-03-22', '14:30:00' ), 'American Airlines', 'AA', 'AA2342', 'Economy', 254.20);
insert into available_flights (id, departure_airport_code, departure_time, arrival_airport_code, arrival_time, airline, airline_code, airline_flight_number, class_of_service, price)  
values (NULL, 'JFK', TIMESTAMP ( '2012-03-26', '14:00:00' ), 'DEN', TIMESTAMP ( '2012-03-22', '16:30:00' ), 'American Airlines', 'AA', 'AA1422', 'Economy', 230.10);
