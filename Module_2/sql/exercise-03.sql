-- 3. Inactive Users
-- Retrieve users who have not registered for any events in the last 90 days.

SELECT u.user_id, u.full_name, u.email
FROM Users u
LEFT JOIN Registrations r ON u.user_id = r.user_id
  AND r.registration_date >= CURDATE() - INTERVAL 90 DAY
WHERE r.registration_id IS NULL;
