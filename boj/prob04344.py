# Backjoon Online Judge: https://www.acmicpc.net/problem/4344
# 내용없음

import sys
from collections import deque

n = int(sys.stdin.readline())

for _1 in range(n):
    scores = deque(map(int, sys.stdin.readline().split()))
    length = scores.popleft()
    avg = sum(scores) / length
    higher = 0
    for _2 in range(length):
        if scores.pop() > avg:
            higher += 1
    print(format(higher / length * 100, ".3f")+'%')
