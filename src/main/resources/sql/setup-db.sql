ALTER SESSION SET CURRENT_SCHEMA = HRSTUDENT11;

create table member
(
    id INT,
    constraint member_pk primary key (id)
);

create table contact_person
(
    id                  number(*)     not null,
    first_name          varchar2(264),
    last_name           varchar2(264),
    email               varchar2(264) not null,
    mobile_phone_number varchar2(264),
    phone_number        varchar2(264),
    address_id          number,
    constraint contact_person_pk primary key (id)
);
alter table contact_person
    add constraint contact_address_fk foreign key (address_id) references address (id);


create table parking_lot
(
    id                number(*)     not null,
    external_id       varchar2(264) not null,
    name              varchar2(264) not null,
    category          varchar2(264),
    max_capacity      number(*),
    contact_person_id number(*)     not null,
    address_id        number(*)     not null,
    price_per_hour    number(*),
    constraint parking_lot_pk primary key (id)
);

alter table parking_lot
    add constraint parking_address_fk foreign key (address_id) references address (id);

alter table parking_lot
    add constraint parking_contact_fk foreign key (contact_person_id) references contact_person (id);

create sequence contact_person_seq;
create sequence parking_lot_seq;