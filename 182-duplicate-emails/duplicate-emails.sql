# Write your MySQL query statement belows
-- select count(email) as countEmail ,email from person group by email;
select email as "Email" from person  group by email having count(email) >1;