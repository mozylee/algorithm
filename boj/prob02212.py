# 출처: https://www.acmicpc.net/problem/2212
# 문제: 센서

import sys

read = sys.stdin.readline

n = int(read())
k = int(read())
if k >= n:
    print(0)
    exit(0)

dots = sorted(map(int, read().split()))
distances = sorted([dots[i + 1] - dots[i] for i in range(n - 1)], reverse=True)

for i in range(k - 1):
    distances[i] = 0
print(sum(distances))
