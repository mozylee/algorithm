# Backjoon Online Judge: https://www.acmicpc.net/problem/2588
# 내용없음

import sys

m = int(sys.stdin.readline())
n = int(sys.stdin.readline())
n1, n2, n3 = map(int, str(n))

print(m * n3)
print(m * n2)
print(m * n1)
print(m * n)
