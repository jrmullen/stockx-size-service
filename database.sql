-- Create database
CREATE DATABASE stockx_db;


-- Create user
CREATE USER stockx;


-- Create table
CREATE TABLE shoe
(
    id SERIAL PRIMARY KEY NOT NULL,
    display VARCHAR(128),
    key VARCHAR(128) NOT NULL,
    true_to_size_score INTEGER
);
-- Table's PK
CREATE UNIQUE INDEX shoe_id_uindex ON shoe (id);


-- Insert table data from PDF
INSERT INTO shoe(display, key, true_to_size_score) VALUES
    ('Adidas Yeezy', 'adidas-yeezy', 1),
    ('Adidas Yeezy', 'adidas-yeezy', 2),
    ('Adidas Yeezy', 'adidas-yeezy', 2),
    ('Adidas Yeezy', 'adidas-yeezy', 3),
    ('Adidas Yeezy', 'adidas-yeezy', 2),
    ('Adidas Yeezy', 'adidas-yeezy', 3),
    ('Adidas Yeezy', 'adidas-yeezy', 2),
    ('Adidas Yeezy', 'adidas-yeezy', 2),
    ('Adidas Yeezy', 'adidas-yeezy', 3),
    ('Adidas Yeezy', 'adidas-yeezy', 4),
    ('Adidas Yeezy', 'adidas-yeezy', 2),
    ('Adidas Yeezy', 'adidas-yeezy', 5),
    ('Adidas Yeezy', 'adidas-yeezy', 2),
    ('Adidas Yeezy', 'adidas-yeezy', 3);