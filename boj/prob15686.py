# 출처: https://www.acmicpc.net/problem/15686
# 문제: 치킨 배달


def get_distance(c1, c2):
    return abs(c1[0] - c2[0]) + abs(c1[1] - c2[1])


import sys
from itertools import combinations

read = sys.stdin.readline

n, m = map(int, read().split())
houses = []
chickens = []
result = 1e9
for i in range(n):
    for j, c in enumerate(map(int, read().split())):
        if c == 1:
            houses.append((i, j))
        elif c == 2:
            chickens.append((i, j))

for combination in combinations(chickens, m):
    sum_distance = 0

    for h in houses:
        min_distance = n ** 3
        for c in combination:
            min_distance = min(min_distance, get_distance(h, c))
        sum_distance += min_distance
    result = min(sum_distance, result)

print(result)
