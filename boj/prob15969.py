# 출처: https://www.acmicpc.net/problem/15969
# 문제: 행복


import sys

read = sys.stdin.readline

_ = read()
scores = list(map(int, read().split()))

print(max(scores) - min(scores))

