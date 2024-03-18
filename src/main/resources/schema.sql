CREATE TABLE products
(
    id              INT AUTO_INCREMENT PRIMARY KEY,
    photo_url       VARCHAR(255),
    title           VARCHAR(255),
    description     TEXT,
    price           DECIMAL(10, 2),
    sale_price      DECIMAL(10, 2),
    sale_percentage DECIMAL(5, 2),
    rating          DECIMAL(3, 1),
    review_count    INT
);
