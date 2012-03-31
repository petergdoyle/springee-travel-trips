
delete from flights;

insert into flights (id, departureAirportCode, departureTime, arrivalAirportCode, arrivalTime, airline, airlineCode, airlineFlightNumber, classOfService, price)  
values (NULL, 'DEN', TIMESTAMP ( '2012-03-22', '07:00:00' ), 'JFK', TIMESTAMP ( '2012-03-22', '09:30:00' ), 'United Airlines', 'UA', 'UA2833', 'Economy', 253.20);
insert into flights (id, departureAirportCode, departureTime, arrivalAirportCode, arrivalTime, airline, airlineCode, airlineFlightNumber, classOfService, price)  
values (NULL, 'DEN', TIMESTAMP ( '2012-03-22', '09:30:00' ), 'JFK', TIMESTAMP ( '2012-03-22', '11:30:00' ), 'United Airlines', 'UA', 'UA1772', 'Economy', 217.10);
insert into flights (id, departureAirportCode, departureTime, arrivalAirportCode, arrivalTime, airline, airlineCode, airlineFlightNumber, classOfService, price)  
values (NULL, 'DEN', TIMESTAMP ( '2012-03-22', '11:00:00' ), 'JFK', TIMESTAMP ( '2012-03-22', '14:30:00' ), 'American Airlines', 'AA', 'AA3824', 'Economy', 212.20);
insert into flights (id, departureAirportCode, departureTime, arrivalAirportCode, arrivalTime, airline, airlineCode, airlineFlightNumber, classOfService, price)  
values (NULL, 'DEN', TIMESTAMP ( '2012-03-22', '14:00:00' ), 'JFK', TIMESTAMP ( '2012-03-22', '16:30:00' ), 'American Airlines', 'AA', 'AA2727', 'Economy', 280.10);

insert into flights (id, departureAirportCode, departureTime, arrivalAirportCode, arrivalTime, airline, airlineCode, airlineFlightNumber, classOfService, price)  
values (NULL, 'JFK', TIMESTAMP ( '2012-03-26', '07:00:00' ), 'DEN', TIMESTAMP ( '2012-03-22', '09:30:00' ), 'United Airlines', 'UA', 'UA5432', 'Economy', 280.20);
insert into flights (id, departureAirportCode, departureTime, arrivalAirportCode, arrivalTime, airline, airlineCode, airlineFlightNumber, classOfService, price)  
values (NULL, 'JFK', TIMESTAMP ( '2012-03-26', '09:30:00' ), 'DEN', TIMESTAMP ( '2012-03-22', '11:30:00' ), 'United Airlines', 'UA', 'UA6784', 'Economy', 317.10);
insert into flights (id, departureAirportCode, departureTime, arrivalAirportCode, arrivalTime, airline, airlineCode, airlineFlightNumber, classOfService, price)  
values (NULL, 'JFK', TIMESTAMP ( '2012-03-26', '11:00:00' ), 'DEN', TIMESTAMP ( '2012-03-22', '14:30:00' ), 'American Airlines', 'AA', 'AA2342', 'Economy', 254.20);
insert into flights (id, departureAirportCode, departureTime, arrivalAirportCode, arrivalTime, airline, airlineCode, airlineFlightNumber, classOfService, price)  
values (NULL, 'JFK', TIMESTAMP ( '2012-03-26', '14:00:00' ), 'DEN', TIMESTAMP ( '2012-03-22', '16:30:00' ), 'American Airlines', 'AA', 'AA1422', 'Economy', 230.10);
