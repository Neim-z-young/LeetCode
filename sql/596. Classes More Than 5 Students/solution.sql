# Write your MySQL query statement below
Select class from (select distinct student, class from courses) as A
group by class having count(*)>=5;