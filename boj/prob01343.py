from collections import deque

A, B = 'AAAA', 'BB'
board = deque(input())

ans = ""
count = 0
while board:
    while board and board[0] != 'X':
        ans += board.popleft()
    while board and board[0] == 'X':
        count += 1
        board.popleft()

    if count % 2 == 1:
        ans = '-1'
        break

    ans += A * (count//4) + (B if count % 4 > 0 else "")
    count = 0

print(ans)
