# Write your MySQL query statement below

#MYSQL 版本
SELECT DISTINCT A.NUM AS ConsecutiveNums FROM LOGS AS A
WHERE A.NUM = (
    SELECT B.NUM FROM LOGS AS B
    WHERE B.ID = A.ID+1 AND B.NUM = (
        SELECT C.NUM FROM LOGS AS C
        WHERE C.ID=B.ID+1
    )
);

/* Write your T-SQL query statement below */
/* MS sql 版本*/
;WITH SEL AS(
    SELECT NUM, LAG(NUM) OVER(ORDER BY ID) AS PRE, LEAD(NUM) OVER(ORDER BY ID) AS NEX FROM LOGS
)
SELECT DISTINCT NUM AS ConsecutiveNums FROM SEL
WHERE NUM=PRE AND NUM = NEX;