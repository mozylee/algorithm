# Backjoon Online Judge: https://www.acmicpc.net/problem/2439
# 내용없음

import sys

n = int(sys.stdin.readline())

for i in range(1, n + 1):
    print(' ' * (n - i) + '*' * i)
