# 출처: https://www.acmicpc.net/problem/2012
# 문제: 등수 매기기

import sys

read = sys.stdin.readline
rankings = sorted(int(read()) for _ in range(int(read())))
count = 0
for i, ranking in enumerate(rankings):
    count += abs(i + 1 - ranking)
print(count)
