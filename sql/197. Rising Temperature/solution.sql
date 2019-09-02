# Write your MySQL query statement below
SELECT A.ID AS Id FROM WEATHER A JOIN WEATHER B ON 
DATEDIFF(A.RECORDDATE, B.RECORDDATE)=1 AND A.TEMPERATURE>B.TEMPERATURE