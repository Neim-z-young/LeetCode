### LIMIT N, M 等价于 LIMIT M OFFSET N 
### LINIT M 等价于 LIMIT 0, M 


CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
DECLARE M INT;
IF N=0 THEN
    SET M=0;
ELSE
    SET M=N-1;
END IF;
  RETURN (
      # Write your MySQL query statement below.
      SELECT (
          SELECT DISTINCT SALARY 
          FROM EMPLOYEE 
          ORDER BY SALARY DESC LIMIT 1 OFFSET M
      )
      
  );
END