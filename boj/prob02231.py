# 출처: https://www.acmicpc.net/problem/2231
# 문제: 분해합

n = int(input())

for i in range(1, n):
    decomposition = i + sum(map(int, str(i)))
    if decomposition == n:
        print(i)
        exit(0)

print(0)
