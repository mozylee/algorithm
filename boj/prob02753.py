# Backjoon Online Judge: https://www.acmicpc.net/problem/2753
# 내용없음

import sys

year = int(sys.stdin.readline())
print(1 if (year % 4 == 0 and not year % 100 == 0) or year % 400 == 0 else 0)
