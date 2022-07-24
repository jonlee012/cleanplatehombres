
USE cleanPlate_db;


INSERT INTO user_info (username, email, password, is_admin)
VALUES ('michael', 'michael@email.com', '$2a$10$SxrR4P38ZE4DJiljwQCTr.N0UVOu2CcCZurS4RIyMeKkt3by0sRzS', false),
       ('carlos', 'carlos@email.com', '$2a$10$vtZ5ov5Mq/GH7TQFj4rdp./5B66TZRO805fjg9.QmUm1p7f.VewYS', false),
       ('jon', 'jon@email.com', '$2a$10$JfZRsgEcmBqwK5pxKLSg3ePAjOCGpJ6w..hkZBOoYuxmHsK1ogVIi', false),
        ('derek', 'derek@email.com', '$2a$10$M6.1RYuRwX2EBVxyes7y/eP5nDE8.Eq7OmE9/sW.AvnxwbzmiZAAe', true),
       ('bob', 'bob@email.com', '$2a$10$LmRTjwAk7MfkSYV9Axa/6utaIyQkk181Iacrq1tIUCC.s.CgSCvou', true);


INSERT INTO org_info (org_name, org_description, org_st_address, org_city, org_state, org_zip, is_donor, user_id)
VALUES ('Pinkerton BBQ', 'Best BBQ in San Antonio', '107 W Houston Street', 'San Antonio', 'Texas', 78205, true, 1),
       ('Yard House', 'Soo many beers to choose from', '849 E Commerce Street', 'San Antonio', 'Texas', 78205, true, 2),
       ('Carazon Ministries Inc.', 'Food Distribution Center', '230 E Travis Street', 'San Antonio', 'Texas', 78205, false, 3),
       ('Salvation Army ARC', 'Food Distribution Center', '1324 S Flores Street', 'San Antonio', 'Texas', 78204, false, 4);

INSERT INTO listing (food_name, food_amt, donation_description, is_donation, exp_date, is_fulfilled, ad_user_id, ad_org_id)
VALUES ('brisket and ribs', '50 lbs', 'Ready for pickup after 11:00 pm', true, '2022-08-06', false, 1, 1),
       ('meatloaf and mashed potatoes', '25 lbs', 'catering contract fell through last minute', true, '2022-08-06', false, 2, 2),
       ('canned vegetables', '250 cans', 'hoping to meet recommended macros for ready meals', false, '2022-08-06', false, 3, 3),
       ('hot meals', '50 meals', 'seeking to support local low income daycare', false, '2022-08-06', false, 4, 4);

INSERT INTO category (category_name)
VALUES ('meat'),
       ('vegetables'),
       ('vegetarian'),
       ('omnivore'),
       ('perishables'),
       ('canned'),
       ('baked goods'),
       ('vegan');

INSERT INTO listing_categories (listing_id, category_id)
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









