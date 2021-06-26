# 출처: https://www.acmicpc.net/problem/1654
# 문제: 랜선 자르기


import sys

read = sys.stdin.readline

k, n = map(int, read().split())
lan_cables = [int(read()) for _ in range(k)]

s, e = 1, max(lan_cables)
while s <= e:
    mid = (s + e) // 2
    count_cables = sum(cable // mid for cable in lan_cables)
    if count_cables >= n:
        s = mid + 1
    else:
        e = mid - 1
print(e)  # or (s - 1)
