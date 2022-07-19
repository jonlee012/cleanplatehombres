USE cleanPlate_db;


INSERT INTO user_info (username, email, password, is_admin)
VALUES ('michael', 'michael@email.com', 'michael123', false),
       ('carlos', 'carlos@email.com', 'carlos123', false),
       ('jon', 'jon@email.com', 'jon123', false),
       ('derek', 'derek@email.com', 'derek123', false),
       ('bob', 'bob@email.com', 'bob123', true);


INSERT INTO org_info (org_name, org_description, org_st_address, org_city, org_state, org_zip, is_donor, user_info)
VALUES ('Pinkerton BBQ', 'Best BBQ in San Antonio', '107 W Houston Street', 'San Antonio', 'Texas', 78205, true, 1),
       ('Yard House', 'Soo many beers to choose from', '849 E Commerce Street', 'San Antonio', 'Texas', 78205, true, 2),
       ('Carazon Ministries Inc.', 'Food Distribution Center', '230 E Travis Street', 'San Antonio', 'Texas', 78205, false, 3),
       ('Salvation Army ARC', 'Food Distribution Center', '1324 S Flores Street', 'San Antonio', 'Texas', 78204, false, 4);

INSERT INTO listing (food_name, food_amt, donation_description, is_donation, exp_date, is_fulfilled, org_info)
VALUES ('brisket and ribs', '50 lbs', 'Ready for pickup after 11:00 pm', true, '2022-08-06', false, 1),
       ('meatloaf and mashed potatoes', '25 lbs', 'catering contract fell through last minute', true, '2022-08-06', false, 2),
       ('canned vegetables', '250 cans', 'hoping to meet recommended macros for ready meals', false, '2022-08-06', false, 3),
       ('hot meals', '50 meals', 'seeking to support local low income daycare', false, '2022-08-06', false, 4);

INSERT INTO category (category_name)
VALUES ('meat'),
       ('vegetables'),
       ('vegetarian'),
       ('omnivore'),
       ('perishables'),
       ('canned'),
       ('baked goods'),
       ('vegan');

INSERT INTO listing_categories (listingId, categoryId)
VALUES (1, 1),
       (1, 4),
       (1, 5),
       (2, 4),
       (2, 1),
       (2, 2),
       (3, 2),
       (3, 6),
       (3, 8),
       (4, 4),
       (4, 1),
       (4, 2),
       (3, 3);









