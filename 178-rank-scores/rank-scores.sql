# Write your MySQL query statement below
SELECT score ,
DENSE_RANK() OVER(order by score desc) as 'rank' 
from Scores order by score desc;
