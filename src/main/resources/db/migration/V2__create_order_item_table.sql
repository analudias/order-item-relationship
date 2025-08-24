CREATE TABLE IF NOT EXISTS tb_order_item (
    id UUID PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    order_id UUID,
    FOREIGN KEY (order_id) REFERENCES tb_order (id)
);