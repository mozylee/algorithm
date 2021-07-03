-- 출처: https://programmers.co.kr/learn/courses/30/lessons/59413
-- 문제: 입양 시각 구하기 2

-- SET @~~ 는 처음 써봅니다.

SET @h = -1;
SELECT @h := @h + 1 AS HOUR, (SELECT COUNT(*)
                              FROM ANIMAL_OUTS AS A
                              WHERE HOUR(A.DATETIME) = @h) AS COUNT
FROM ANIMAL_OUTS
WHERE @h < 23
ORDER BY @h