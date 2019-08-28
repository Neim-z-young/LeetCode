# Write your MySQL query statement below
###FIRST
select (
   select distinct a.Salary from Employee a
   order by a.Salary desc
   limit 1, 1
)as SecondHighestSalary;


### SECOND
select max(Salary) as SecondHighestSalary from
Employee where Salary < (
    Select max(Salary) from employee
);