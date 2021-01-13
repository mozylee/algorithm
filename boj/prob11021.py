# Backjoon Online Judge: https://www.acmicpc.net/problem/11021
# 내용없음

import sys

T = int(sys.stdin.readline())
for x in range(1, T + 1):
    print(f"Case #{x}: {sum(map(int, sys.stdin.readline().split()))}")
