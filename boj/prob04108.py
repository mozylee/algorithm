import sys


read = sys.stdin.readline

dx = [-1, -1, -1, 0, 1, 1, 1, 0]
dy = [-1, 0, 1, 1, 1, 0, -1, -1]


def get_count(i: int, j: int, board: list) -> str:
    count = 0
    for k in range(8):
        nx = i+dx[k]
        ny = j+dy[k]

        if is_oob(nx, ny, board):
            continue

        count += 1 if board[nx][ny] == '*' else 0

    return str(count)


def is_oob(nx, ny, board) -> bool:
    return nx < 0 or nx >= len(board) or ny < 0 or ny >= len(board[0])


ans = []
while True:
    R, C = map(int, read().split())
    if R == 0:
        break

    board = [list(read().rstrip()) for _ in range(R)]
    for i in range(R):
        for j in range(C):
            if board[i][j] == '*':
                continue
            board[i][j] = get_count(i, j, board)
    ans.append("\n".join("".join(line) for line in board))

print(*ans, sep="\n")
