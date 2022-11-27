import sys


read = sys.stdin.readline

A, B = map(int, read().split())

Ax, Ay = divmod(A-1, 4)
Bx, By = divmod(B-1, 4)

print(abs(Ax-Bx) + abs(Ay-By))
