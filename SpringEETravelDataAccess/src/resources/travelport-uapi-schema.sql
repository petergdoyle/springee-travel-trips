drop table if exists universal_records cascade; 
drop table if exists flights cascade; 
drop table if exists air_segments cascade; 
drop table if exists flights cascade; 
drop table if exists form_of_payments cascade; 
drop table if exists passenger_details cascade; 

create table universal_records (
    id bigint generated by default as identity(start with 1) primary key, 
    create_date datetime not null
)

create table air_segments (
    id bigint generated by default as identity(start with 1) primary key, 
    create_date datetime not null,
    universal_record_id bigint not null,
    constraint fk_air_segments_universal_record_id foreign key(universal_record_id) references universal_records(id)
)

create table flights (
    id bigint generated by default as identity(start with 1) primary key, 
    departure_airport_code varchar_ignorecase(50) not null,   
    departure_time datetime not null,   
    arrival_airport_code varchar_ignorecase(50) not null,
    arrival_time datetime not null,   
    airline varchar_ignorecase(50) not null,
    airline_code varchar_ignorecase(50) not null,
    airline_flight_number varchar_ignorecase(50) not null,
    class_of_service varchar_ignorecase(50) not null,
    price float not null,
    air_segment_id bigint,
    constraint fk_flights_air_sement_id foreign key(air_segment_id) references air_segments(id)
)

create table form_of_payments (
    id bigint generated by default as identity(start with 1) primary key, 
    form_of_paymentType varchar_ignorecase(50) not null,   
    credit_card_number varchar_ignorecase(50)  null,
    credit_card_name varchar_ignorecase(50) null,
    credit_expiry varchar_ignorecase(4),
    credit_ccid varchar_ignorecase(3),
    air_segment_id bigint not null,
    constraint fk_fop_air_sement_id foreign key(air_segment_id) references air_segments(id)
)


create table passenger_details (
    id bigint generated by default as identity(start with 1) primary key, 
    first_name varchar_ignorecase(50) not null,   
    last_name varchar_ignorecase(50) not null,   
    initials varchar_ignorecase(50) not null,   
    contact_phone varchar_ignorecase(50) not null,
    contact_email varchar_ignorecase(50) not null,
    country_of_residenceCode varchar_ignorecase(50) not null,
    country_of_nationality varchar_ignorecase(50) not null,
    passport_Id varchar_ignorecase(50) not null,
    air_segment_id bigint not null,
    constraint fk_passenger_details_air_sement_id foreign key(air_segment_id) references air_segments(id)
)
