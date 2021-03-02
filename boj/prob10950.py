# Backjoon Online Judge: https://www.acmicpc.net/problem/10950
# 내용없음

import sys

n = int(sys.stdin.readline())

for _ in range(n):
    print(sum(map(int, sys.stdin.readline().split())))
