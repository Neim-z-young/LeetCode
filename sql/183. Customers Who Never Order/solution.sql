# Write your MySQL query statement below
SELECT A.NAME AS Customers FROM CUSTOMERS AS A LEFT OUTER JOIN ORDERS AS B ON A.ID = B.CUSTOMERID
WHERE B.CUSTOMERID IS NULL;