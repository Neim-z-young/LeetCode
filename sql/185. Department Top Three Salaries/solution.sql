# Write your MySQL query statement below
SELECT 
    A.NAME AS Department, E1.NAME AS Employee, E1.Salary 
FROM 
    DEPARTMENT AS A 
        JOIN
    EMPLOYEE AS E1 ON A.ID = E1.DEPARTMENTID
WHERE
3 > (
    SELECT 
        COUNT(DISTINCT E2.SALARY)
    FROM 
        EMPLOYEE AS E2
    WHERE 
        E2.DEPARTMENTID = E1.DEPARTMENT 
            AND E2.SALARY>E1.SALARY
)

