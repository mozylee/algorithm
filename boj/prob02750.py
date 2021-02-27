# Backjoon Online Judge: https://www.acmicpc.net/problem/2750
# 내용없음

import sys

n = int(sys.stdin.readline())
arr = list()
for _ in range(n):
    arr.append(int(sys.stdin.readline()))

print('\n'.join(map(str, sorted(arr))))
