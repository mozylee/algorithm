from math import sqrt
import sys


read = sys.stdin.readline

N = int(read())
board = [list(map(int, read().split())) for _ in range(N)]

x1, y1, x2, y2 = 1e9, 1e9, -1, -1

for i in range(N):
    for j in range(N):
        if board[i][j] < 2:
            continue

        x1, y1 = min(x1, i), min(y1, j)
        x2, y2 = max(x2, i), max(y2, j)

distance = sqrt((x1-x2)**2 + (y1-y2)**2)
total = sum(board[i][j] for i in range(x1, x2+1)
            for j in range(y1, y2+1))-7
print(1 if total >= 3 and distance >= 5 else 0)
