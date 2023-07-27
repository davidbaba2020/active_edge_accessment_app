CREATE TABLE stock (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    current_price DOUBLE NOT NULL,
    create_date TIMESTAMP NOT NULL,
    last_update TIMESTAMP NOT NULL
);

INSERT INTO stock (name, current_price, create_date, last_update) VALUES
('Stock A', 100.0, current_timestamp, current_timestamp),
('Stock B', 200.0, current_timestamp, current_timestamp),
('Stock C', 150.0, current_timestamp, current_timestamp),
('Stock D', 175.0, current_timestamp, current_timestamp),
('Stock E', 120.0, current_timestamp, current_timestamp),
('Stock F', 90.0, current_timestamp, current_timestamp),
('Stock G', 80.0, current_timestamp, current_timestamp),
('Stock H', 250.0, current_timestamp, current_timestamp),
('Stock I', 180.0, current_timestamp, current_timestamp),
('Stock J', 130.0, current_timestamp, current_timestamp),
('Stock K', 220.0, current_timestamp, current_timestamp),
('Stock L', 300.0, current_timestamp, current_timestamp),
('Stock M', 95.0, current_timestamp, current_timestamp),
('Stock N', 240.0, current_timestamp, current_timestamp),
('Stock O', 160.0, current_timestamp, current_timestamp),
('Stock P', 110.0, current_timestamp, current_timestamp),
('Stock Q', 70.0, current_timestamp, current_timestamp),
('Stock R', 210.0, current_timestamp, current_timestamp),
('Stock S', 130.0, current_timestamp, current_timestamp),
('Stock T', 185.0, current_timestamp, current_timestamp),
('Stock U', 270.0, current_timestamp, current_timestamp),
('Stock V', 140.0, current_timestamp, current_timestamp),
('Stock W', 95.0, current_timestamp, current_timestamp),
('Stock X', 100.0, current_timestamp, current_timestamp),
('Stock Z', 200.0, current_timestamp, current_timestamp);
