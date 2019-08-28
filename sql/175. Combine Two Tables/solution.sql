# Write your MySQL query statement below
#采用左外连接
select a.FirstName, a.LastName, b.City, b.State 
from Person a left outer join Address b on a.PersonId=b.PersonId;