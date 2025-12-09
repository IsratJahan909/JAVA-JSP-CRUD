-- SQL script to set up the database and table
-- Replace 'your_db_name' with your desired database name
CREATE DATABASE IF NOT EXISTS product_db;

USE product_db;

-- Table structure for Product entity
CREATE TABLE IF NOT EXISTS product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    description VARCHAR(500),
    stock_quantity INT NOT NULL DEFAULT 0
);

-- Insert some sample data
INSERT INTO product (name, price, description, stock_quantity) VALUES
('Laptop', 1200.00, 'High-performance laptop for professionals.', 10),
('Smartphone', 699.50, 'Latest model with advanced camera.', 50),
('Headphones', 99.99, 'Noise-cancelling over-ear headphones.', 100);
