import sys


read = sys.stdin.readline

N = int(read())
board = [read().rstrip() for _ in range(N)]
ans = [[0]*N for _ in range(N)]


dx = [-1, -1, -1, 0, 1, 1, 1, 0]
dy = [-1, 0, 1, 1, 1, 0, -1, -1]
for i in range(N):
    for j in range(N):
        if board[i][j] != '.':
            ans[i][j] = '*'
            continue

        count = 0
        for k in range(8):
            nx, ny = i+dx[k], j+dy[k]
            if nx < 0 or nx >= N or ny < 0 or ny >= N or board[nx][ny] == '.':
                continue
            
            count += int(board[nx][ny])

        ans[i][j] = count if count<10 else 'M'

print("\n".join("".join(map(str, line)) for line in ans))
