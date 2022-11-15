import sys

read = sys.stdin.readline

EMPTY, MOUNTAIN, HIGHWAY, BRIDGE, TUNNEL = range(5)
characters = {EMPTY: '.', MOUNTAIN: '#',
              HIGHWAY: '-', BRIDGE: '|', TUNNEL: '*'}

N, M, X = map(int, read().split())
X = N-X
board = [[EMPTY]*M for _ in range(N)]

for i, height in enumerate(map(int, read().split())):
    for h in range(N-1, N-height-1, -1):
        board[h][i] = MOUNTAIN


for i in range(M):
    if board[X][i] == EMPTY:
        board[X][i] = HIGHWAY
    elif board[X][i] == MOUNTAIN:
        board[X][i] = TUNNEL

    if (i+1) % 3 == 0:
        height = X+1
        while height < N and board[height][i] == EMPTY:
            board[height][i] = BRIDGE
            height += 1


print(*("".join(characters[x] for x in line) for line in board), sep="\n")
