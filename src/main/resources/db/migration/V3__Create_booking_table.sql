CREATE TABLE booking (
    booking_id SERIAL PRIMARY KEY,
    buyer_id INT NOT NULL REFERENCES users(user_id),
    seller_id INT NOT NULL REFERENCES users(user_id),
    product_id INT NOT NULL REFERENCES products(product_id),
    transaction_amount DECIMAL(10, 2) NOT NULL,
    payment_id INT,
    status VARCHAR(20) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);