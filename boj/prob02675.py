# Backjoon Online Judge: https://www.acmicpc.net/problem/2675
# 내용없음

import sys

n = int(sys.stdin.readline())

for _ in range(n):
    length, s = sys.stdin.readline().rstrip().split()
    length = int(length)
    print("".join([char * length for char in s]))
