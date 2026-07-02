-- 5. Most Active Cities
-- List the top 5 cities with the highest number of distinct user registrations.

SELECT e.city, COUNT(DISTINCT r.user_id) AS distinct_registrations
FROM Events e
JOIN Registrations r ON e.event_id = r.event_id
GROUP BY e.city
ORDER BY distinct_registrations DESC
LIMIT 5;
