# Backjoon Online Judge: https://www.acmicpc.net/problem/10430
# 내용없음

import sys

A, B, C = map(int, sys.stdin.readline().split())
result = [(A + B) % C, ((A % C) + (B % C)) % C, (A * B) % C, ((A % C) * (B % C)) % C]
print('\n'.join(map(str, result)))
