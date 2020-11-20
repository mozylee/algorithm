# Backjoon Online Judge: https://www.acmicpc.net/problem/10869
# 내용없음

import sys

m, n = map(int, sys.stdin.readline().split())
print('\n'.join(map(str, [m + n, m - n, m * n, m // n, m % n])))
