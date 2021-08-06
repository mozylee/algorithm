# Backjoon Online Judge: https://www.acmicpc.net/problem/1110
# 내용없음

n = int(input())
cycle, result = 0, n

while True:
    cycle += 1
    tens, units = result // 10, result % 10
    result = units * 10 + (tens + units) % 10
    if result == n:
        break
print(cycle)
