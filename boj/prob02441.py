# Backjoon Online Judge: https://www.acmicpc.net/problem/2441
# 내용없음

import sys

n = int(sys.stdin.readline())

for i in range(n, 0, -1):
    print(' ' * (n - i) + '*' * i)
