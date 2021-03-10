# Backjoon Online Judge: https://www.acmicpc.net/problem/2577
# 내용없음

import sys

A = int(sys.stdin.readline())
B = int(sys.stdin.readline())
C = int(sys.stdin.readline())

counter = {str(i): 0 for i in range(10)}
for i in list(str(A * B * C)):
    counter[i] += 1

print('\n'.join(map(str, counter.values())))