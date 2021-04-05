# Backjoon Online Judge: https://www.acmicpc.net/problem/15552
# 내용없음

import sys

n = int(sys.stdin.readline())
for i in range(n):
    print(sum(map(int, sys.stdin.readline().split())))
