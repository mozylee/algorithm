# Backjoon Online Judge: https://www.acmicpc.net/problem/8958
# 내용없음

import sys

n = int(sys.stdin.readline())

for _ in range(n):
    line = sys.stdin.readline().rstrip()
    result = 0
    bonus = 0
    for char in line:
        if char == 'X':
            bonus = 0
            continue
        bonus += 1
        result += bonus
    print(result)
