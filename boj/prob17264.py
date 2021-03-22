# 출처: https://www.acmicpc.net/problem/1302
# 문제: 베스트셀러


import sys
from collections import defaultdict

read = sys.stdin.readline
n, p = map(int, read().split())
w, l, g = map(int, read().split())
score = 0
players = defaultdict(-l)
for _ in range(p):
    name, case = read().rstrip().split()
    players[name] = w if case == 'W' else -l

for _ in range(n):
    case = players[read().rstrip()]
    if case <= 0:
        score = score - l if score >= l else 0
    else:
        score += case
