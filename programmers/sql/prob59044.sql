-- 출처: https://programmers.co.kr/learn/courses/30/lessons/59044
-- 문제: 오랜기간 보호한 동물 1

SELECT A_IN.NAME, A_IN.DATETIME
FROM ANIMAL_INS AS A_IN LEFT JOIN ANIMAL_OUTS AS A_OUT
ON A_IN.ANIMAL_ID = A_OUT.ANIMAL_ID
WHERE A_OUT.DATETIME IS NULL
ORDER BY A_IN.DATETIME
LIMIT 3