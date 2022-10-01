from collections import Counter
import sys


read = sys.stdin.readline

M, N = map(int, read().split())

windows = [[0]*N for _ in range(M)]
board = [line.rstrip() for line in sys.stdin.readlines()]
for i in range(M):
    for j in range(N):
        for k in range(5):
            if(board[5*i+1+k][5*j+1] == "*"):
                windows[i][j] += 1

c = Counter(sum(windows, []))
print(*(c[i] for i in range(5)), sep=" ")
