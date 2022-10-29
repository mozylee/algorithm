import sys


read = sys.stdin.readline

N, M = map(int, read().split())
board = [[0]*(M+1)]
board.extend([[0]+list(map(int, read().split())) for _ in range(N)])

for i in range(N+1):
    for j in range(M):
        board[i][j+1] += board[i][j]

for i in range(N):
    for j in range(M+1):
        board[i+1][j] += board[i][j]

ans = []
for i, j, x, y in (map(int, read().split()) for _ in range(int(read()))):
    ans.append(board[x][y]-board[x][j-1]-board[i-1][y]+board[i-1][j-1])

print(*ans, sep="\n")
