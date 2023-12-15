SELECT COUNT(*) FROM customer;
SELECT * FROM rental WHERE rental.return_date IS NULL LIMIT 10;
SELECT * FROM rental WHERE rental_id = 11496;