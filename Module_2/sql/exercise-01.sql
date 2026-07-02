-- 1. User Upcoming Events
-- Show a list of all upcoming events a user is registered for in their city, sorted by date.

SELECT u.full_name, e.title, e.start_date, e.city
FROM Users u
JOIN Registrations r ON u.user_id = r.user_id
JOIN Events e ON r.event_id = e.event_id
WHERE e.status = 'upcoming'
  AND e.city = u.city
ORDER BY e.start_date;
