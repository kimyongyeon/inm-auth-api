-- 상품 더미 데이터 삽입
INSERT INTO products (photo_url, title, description, price, sale_price, sale_percentage, rating, review_count)
VALUES
    ('https://example.com/product1.jpg', '상품 1', '상품 1 설명', 100.00, 80.00, 20.00, 4.5, 50),
    ('https://example.com/product2.jpg', '상품 2', '상품 2 설명', 80.00, NULL, NULL, 4.0, 30),
    ('https://example.com/product3.jpg', '상품 3', '상품 3 설명', 120.00, 100.00, 16.67, 4.2, 40);
