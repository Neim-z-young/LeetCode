
select i.Day,round((i.cancelled/i.Total),2) as 'Cancellation Rate' from 
(select Request_at as Day,
count(case when status='completed' then 1 else null end) as Completed,
count(case when status in ('cancelled_by_driver','cancelled_by_client') then 1 else null end) as Cancelled,
count(*) as Total
from trips
where (driver_id) not in (select users_id from Users where Banned='Yes')
and (client_id) not in (select users_id from Users where Banned='Yes')
and Request_at between '2013-10-01' and '2013-10-03' 
group by 1) as i


# Write your MySQL query statement below
SELECT REQUEST_AT AS Day, round((CANCELED/TOTAL), 2) AS 'Cancellation Rate' FROM
(SELECT REQUEST_AT, COUNT(A.STATUS) AS TOTAL , 
 SUM(CASE WHEN A.STATUS LIKE '%can%' then 1 else 0 end) AS CANCELED 
 FROM
(SELECT STATUS, REQUEST_AT FROM TRIPS
WHERE REQUEST_AT IN ('2013-10-01', '2013-10-02', '2013-10-03') 
AND CLIENT_ID IN 
    (SELECT USERS_ID FROM USERS WHERE BANNED='No' AND ROLE='client') 
AND DRIVER_ID IN
    (SELECT USERS_ID FROM USERS WHERE BANNED='No' AND ROLE='driver')
) AS A GROUP BY REQUEST_AT) AS B


#### case when 的用法：
#### SUM(1+0+1+0) = 2
#### 有4行 count() = 4

    