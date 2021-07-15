-- 출처: https://programmers.co.kr/learn/courses/30/lessons/77487
-- 문제: 헤비 유저가 소유한 장소

SELECT ID, NAME, P.HOST_ID
FROM PLACES AS P INNER JOIN (SELECT HOST_ID, COUNT(*) AS COUNT FROM PLACES GROUP BY HOST_ID) AS C
ON P.HOST_ID = C.HOST_ID
WHERE COUNT >= 2
ORDER BY ID