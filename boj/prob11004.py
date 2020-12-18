# 출처: https://www.acmicpc.net/problem/11004
# 문제: K번째 수


import sys

read = sys.stdin.readline
_, k = map(int, read().split())
print(sorted(map(int, read().split()))[k - 1])
