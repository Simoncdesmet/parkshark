ALTER SESSION SET CURRENT_SCHEMA = HRSTUDENT11;

create table address
(
    id            number,
    city          varchar(50),
    postal_code   varchar(50),
    street_name   varchar(50),
    street_number varchar(50),
    constraint address_pk primary key (id)
);
create sequence address_seq start with 1 increment by 1;

create table MEMBERSHIP_LEVEL
(
    ID                   NUMBER        not null,
    NAME                 VARCHAR2(264) not null,
    MONTHLY_COST         NUMBER(9, 2),
    ALLOCATION_REDUCTION NUMBER(9, 2),
    MAX_ALLOCATION_HOURS NUMBER
)
/

create unique index MEMBERSHIP_LEVEL_ID_UINDEX
    on MEMBERSHIP_LEVEL (ID)
/

create unique index MEMBERSHIP_LEVEL_NAME_UINDEX
    on MEMBERSHIP_LEVEL (NAME)
/

alter table MEMBERSHIP_LEVEL
    add constraint MEMBERSHIP_LEVEL_PK
        primary key (ID)
/



create table MEMBER
(
    ID                    NUMBER not null
        constraint MEMBER_PK
            primary key,
    FIRST_NAME            VARCHAR2(50),
    LAST_NAME             VARCHAR2(50),
    ADDRESS_ID            NUMBER
        constraint MEMBER_ADDRESS_FK
            references ADDRESS,
    TELEPHONE_NUMBER      VARCHAR2(50),
    EMAIL_ADDRESS         VARCHAR2(50),
    LICENCE_PLATE_NUMBER  VARCHAR2(50),
    LICENCE_PLATE_COUNTRY VARCHAR2(50),
    REGISTRATION_DATE     DATE,
    MEMBERSHIP_LEVEL_ID   NUMBER
        constraint MEMBER_LVL_FK
            references MEMBERSHIP_LEVEL
);
create sequence member_seq start with 1 increment by 1;

create table division
(
    id            number,
    name          varchar(50),
    original_name varchar(50),
    director_name varchar(50),
    parent_division_id number,
    constraint division primary key (id),
    constraint division_parent_fk foreign key (parent_division_id)
        references division (id)
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
    DIVISION_ID       NUMBER
        constraint PARK_LOT_DIV_FK
            references DIVISION
);
create sequence PARKING_LOT_SEQ;

create table PARKING_SPOT_ALLOCATION
(
    ID                   NUMBER        not null
        constraint ALLOCATION_PK
            primary key
        constraint ALLOC_LOT_FK
            references PARKING_LOT,
    EXTERNAL_ID          VARCHAR2(264) not null,
    MEMBER_ID            NUMBER        not null
        constraint ALLOC_MEMBER__FK
            references MEMBER,
    LICENSE_PLATE_NUMBER VARCHAR2(264) not null,
    START_TIME           DATE,
    STOP_TIME            DATE,
    PARKING_LOT_ID       LONG
)
/

create unique index ALLOCATION_EXTERNAL_ID_UINDEX
    on PARKING_SPOT_ALLOCATION (EXTERNAL_ID)
/

create sequence ALLOCATION_SEQ;


