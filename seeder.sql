DROP DATABASE IF EXISTS cleanPlate_db;
CREATE DATABASE IF NOT EXISTS cleanPlate_db;

USE cleanPlate_db;

# INSERT INTO user_info (user_name, user_password, isAdmin)
# VALUES ("testDonor", "testPassword", true);
-- CREATE USER
-- create user donor
-- create user recipient

-- CREATE TABLE org_info (
--                           id INT UNSIGNED NOT NULL AUTO_INCREMENT,
--                           org_name VARCHAR(50) NOT NULL,
--                           org_description VARCHAR(1000) NOT NULL,
--                           org_st_address VARCHAR(50) NOT NULL,
--                           org_st_city VARCHAR(50) NOT NULL,
--                           org_st_state VARCHAR(50) NOT NULL,
--                           org_st_zip LONG NOT NULL,
--                           isDonor BOOLEAN NOT NULL,
--                           user_id INT UNSIGNED NOT NULL,
--                           PRIMARY KEY (id),
--                           FOREIGN KEY (user_id) REFERENCES user(id)
--                               ON DELETE CASCADE
-- );
--
-- CREATE TABLE user (
--                       id INT UNSIGNED NOT NULL AUTO_INCREMENT,
--                       user_name VARCHAR(50) NOT NULL,
--                       user_password
--                           PRIMARY KEY (id),
--                       FOREIGN KEY (user_id) REFERENCES users(id)
--                           ON DELETE CASCADE
-- );