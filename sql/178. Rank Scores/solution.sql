# Write your MySQL query statement below

### 使用自身连接
### GROUP BY s1.id 保证了表中所有行都进行了分组，查询时，每组都将进行运算
SELECT S1.SCORE AS Score, COUNT(DISTINCT S2.SCORE) as Rank FROM SCORES S1, SCORES S2
WHERE S1.SCORE<=S2.SCORE GROUP BY S1.ID ORDER BY S1.SCORE DESC;