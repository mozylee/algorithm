# Backjoon Online Judge: https://www.acmicpc.net/problem/11022
# 내용없음

import sys

T = int(sys.stdin.readline())
for x in range(1, T + 1):
    A, B = map(int, sys.stdin.readline().split())
    print(f"Case #{x}: {A} + {B} = {A + B}")
