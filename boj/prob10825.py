# 출처: https://www.acmicpc.net/problem/10825
# 문제: 국영수


import sys

read = sys.stdin.readline
members = []
for _ in range(int(read())):
    name, *scores = read().rstrip().split()
    members.append((name, *map(int, scores)))
members.sort(key=lambda x: (-x[1], x[2], -x[3], x[0]))
print("\n".join(name for name, *scores in members))
