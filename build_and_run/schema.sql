-- CREATE DATABASE rgt;
USE rgt;
CREATE TABLE users (
	`user_id` BINARY(16) DEFAULT(UUID_TO_BIN(UUID())) PRIMARY KEY,
	`email` VARCHAR(20) NOT NULL,-- UNIQUE
    `name` VARCHAR(20) NOT NULL
);

CREATE TABLE orders (
	`id` BINARY(16) DEFAULT(UUID_TO_BIN(UUID())) PRIMARY KEY,
	`order_id` VARCHAR(20) NOT NULL,
	`product_name` VARCHAR(20) NOT NULL, -- UNIQUE 
	`options` VARCHAR(20),
	`table_no` SMALLINT UNSIGNED NOT NULL,
    `quantity` SMALLINT UNSIGNED NOT NULL,
    `order_date` DATE,
    `order_time` TIME,
    `date_time` TIMESTAMP DEFAULT current_timestamp,
    `robot_status` VARCHAR(20),
    `dong` SMALLINT NOT NULL,
    `ho` SMALLINT NOT NULL,
    `seq` VARCHAR(20) NOT NULL,
    `orderer_name` VARCHAR(20)-- REFERENCES users.name
);