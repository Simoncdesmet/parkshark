ALTER SESSION SET CURRENT_SCHEMA = HRSTUDENT11;

create table address
(
    id            int,
    city          varchar(50),
    postal_code   varchar(50),
    street_name   varchar(50),
    street_number varchar(50),
    constraint address_pk primary key (id)
);
create sequence address_seq start with 1 increment by 1;

create table member
(
    id                    INT,
    first_name            varchar(50),
    last_name             varchar(50),
    address_id            int,
    telephone_number      varchar(50),
    email_address         varchar(50),
    licence_plate_number  varchar(50),
    licence_plate_country varchar(50),
    registration_date     date,
    constraint member_pk primary key (id),
    constraint member_address_fk foreign key (address_id)
        references address (id)
);
create sequence member_seq start with 1 increment by 1;

create table division
(
    id            INT,
    name          varchar(50),
    original_name varchar(50),
    director_name varchar(50),
    constraint division primary key (id)
);
create sequence division_seq start with 1 increment by 1;

create table CONTACT_PERSON
(
    ID                  NUMBER        not null
        constraint CONTACT_PERSON_PK
            primary key,
    FIRST_NAME          VARCHAR2(264),
    LAST_NAME           VARCHAR2(264),
    EMAIL               VARCHAR2(264) not null,
    MOBILE_PHONE_NUMBER VARCHAR2(264),
    PHONE_NUMBER        VARCHAR2(264),
    ADDRESS_ID          NUMBER
        constraint CONTACT_ADDRESS_FK
            references ADDRESS
);
create sequence CONTACT_PERSON_SEQ;

create table PARKING_LOT
(
    ID                NUMBER        not null
        constraint PARKING_LOT_PK
            primary key,
    EXTERNAL_ID       VARCHAR2(264) not null,
    NAME              VARCHAR2(264) not null,
    CATEGORY          VARCHAR2(264),
    MAX_CAPACITY      NUMBER,
    CONTACT_PERSON_ID NUMBER        not null
        constraint PARKING_CONTACT_FK
            references CONTACT_PERSON,
    ADDRESS_ID        NUMBER        not null
        constraint PARKING_ADDRESS_FK
            references ADDRESS,
    PRICE_PER_HOUR    NUMBER,
    DIVISION_ID       INT           not null
        constraint FK_DIVISION_ID   foreign key (DIVISION_ID)
        references DIVISION (id)
);
create sequence PARKING_LOT_SEQ;

create table PARKING_SPOT_ALLOCATION
(
    ID                   number        not null
        constraint ALLOCATION_pk
            primary key,
    EXTERNAL_ID          varchar2(264) not null,
    MEMBER_ID            number        not null
        constraint ALLOC_MEMBER__fk
            references MEMBER,
    LICENSE_PLATE_NUMBER varchar2(264) not null,
    START_TIME           DATE
);
create unique index ALLOCATION_EXTERNAL_ID_uindex
    on PARKING_SPOT_ALLOCATION (EXTERNAL_ID)
/
create sequence ALLOCATION_SEQ;

