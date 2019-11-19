ALTER SESSION SET CURRENT_SCHEMA = HRSTUDENT11;

create table address(
  id int,
  city varchar(50),
  postal_code varchar(50),
  street_name varchar(50),
  street_number varchar(50),
  constraint address_pk primary key (id)
);

create sequence address_seq start with 1 increment by 1;

create table member(
    id INT,
    first_name varchar(50),
    last_name varchar(50),
    address_id int,
    telephone_number varchar(50),
    email_address varchar(50),
    licence_plate_number varchar(50),
    licence_plate_country varchar(50),
    registration_date date,
    constraint member_pk primary key (id),
    constraint member_address_fk foreign key (address_id)
        references address(id)
);

create sequence member_seq start with 1 increment by 1;
