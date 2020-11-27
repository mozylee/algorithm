# Backjoon Online Judge: https://www.acmicpc.net/problem/1330
# 내용없음

import sys

m, n = map(int, sys.stdin.readline().split())

print(">" if m > n else "<" if m < n else "==")
