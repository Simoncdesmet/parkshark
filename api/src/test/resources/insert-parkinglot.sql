insert into ADDRESS (ID, CITY, POSTAL_CODE, STREET_NAME, STREET_NUMBER)
values
(999, 'city', 'postalCode', 'streetName', 'streetNumber');

insert into CONTACT_PERSON
(ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, ADDRESS_ID)
values
(999, 'firstName', 'lastName', 'valid@address.com', 'phoneNumber', 999);

insert into PARKING_LOT
(ID, EXTERNAL_ID, NAME, CATEGORY, MAX_CAPACITY, CONTACT_PERSON_ID, ADDRESS_ID, PRICE_PER_HOUR, DIVISION_ID)
values
(999, 999, 'name', 'UNDERGROUND', 1000, 999, 999, 10, 1);