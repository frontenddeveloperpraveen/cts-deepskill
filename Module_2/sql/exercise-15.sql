-- 15. Event Session Time Conflict
-- Identify overlapping sessions within the same event.

SELECT s1.event_id,
  s1.title AS session1, s1.start_time AS s1_start, s1.end_time AS s1_end,
  s2.title AS session2, s2.start_time AS s2_start, s2.end_time AS s2_end
FROM Sessions s1
JOIN Sessions s2 ON s1.event_id = s2.event_id
  AND s1.session_id < s2.session_id
  AND s1.start_time < s2.end_time
  AND s2.start_time < s1.end_time;
