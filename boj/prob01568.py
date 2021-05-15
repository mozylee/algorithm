# 출처: https://www.acmicpc.net/problem/1568
# 문제: 새


n = int(input())
sec = 0
i = 1

while n > 0:
    if n < i:
        i = 1
        continue
    n -= i
    i += 1
    sec += 1

print(sec)
