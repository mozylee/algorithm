# Backjoon Online Judge: https://www.acmicpc.net/problem/1427
# 내용없음

from sys import stdin

n = stdin.readline().rstrip()

print(''.join(sorted(n, reverse=True)))
