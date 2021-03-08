# Backjoon Online Judge: https://www.acmicpc.net/problem/10871
# 내용없음

import sys

_, x = map(int, sys.stdin.readline().split())
a = list(map(int, sys.stdin.readline().split()))

print(*filter(lambda i: i < x, a))
