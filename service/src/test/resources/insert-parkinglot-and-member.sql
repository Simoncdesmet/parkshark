insert into ADDRESS (ID, CITY, POSTAL_CODE, STREET_NAME, STREET_NUMBER)
values (999, 'Leuven', '3000', 'Straat', '3A');

insert into CONTACT_PERSON
    (ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, ADDRESS_ID)
values (999, 'Jos', 'Verhoeven', 'simoncdesmet@mgail.com', '0516846513', 999);

insert into PARKING_LOT
(ID, EXTERNAL_ID, NAME, CATEGORY, MAX_CAPACITY, CONTACT_PERSON_ID, ADDRESS_ID, PRICE_PER_HOUR)
values (999, 999, 'Name', 'UNDERGROUND', 1, 999, 999, 10);

insert into MEMBER
(ID, FIRST_NAME, LAST_NAME, ADDRESS_ID, TELEPHONE_NUMBER, EMAIL_ADDRESS, LICENCE_PLATE_NUMBER, LICENCE_PLATE_COUNTRY,
 REGISTRATION_DATE)
values (999,
        'Jos',
        'Verhoeven',
        999,
        '0481984',
        'josverhoeven@hotmail.com',
        '1-225-198',
        'Belgium',
        '1992-01-09')