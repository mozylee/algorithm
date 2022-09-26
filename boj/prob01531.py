import sys


read = sys.stdin.readline

N, M = map(int, read().split())
board = [[0]*100 for _ in range(100)]

for _ in range(N):
    x1, y1, x2, y2 = map(int, read().split())

    board[x1-1][y1-1] += 1
    if y2 < 100:
        board[x1-1][y2] -= 1
    if x2 < 100:
        board[x2][y1-1] -= 1
    if x2 < 100 and y2 < 100:
        board[x2][y2] += 1

for i in range(1, 100):
    for j in range(100):
        board[i][j] += board[i-1][j]

count = 0
for i in range(100):
    for j in range(100):
        if j > 0:
            board[i][j] += board[i][j-1]
        count += 1 if board[i][j] > M else 0

print(count)
