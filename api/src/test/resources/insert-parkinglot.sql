

insert into CONTACT_PERSON
(ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, ADDRESS_ID)
values
(999, 'firstName', 'lastName', 'valid@address.com', 'phoneNumber', 999);

insert into PARKING_LOT
(ID, EXTERNAL_ID, NAME, CATEGORY, MAX_CAPACITY, CONTACT_PERSON_ID, ADDRESS_ID, PRICE_PER_HOUR)
values
(999, 999, 'name', 'UNDERGROUND', 1000, 999, 999, 10);