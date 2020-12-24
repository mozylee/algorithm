# 출처: https://www.acmicpc.net/problem/9375
# 문제: 패션왕 신해빈

from sys import stdin

for _1 in range(int(stdin.readline())):
    clothes = {}
    for _2 in range(int(stdin.readline())):
        _3, kind = stdin.readline().rstrip().split()
        if kind not in clothes:
            clothes[kind] = 0
        clothes[kind] += 1
    total = 1
    for amount in clothes.values():
        total *= amount + 1
    print(total - 1)
