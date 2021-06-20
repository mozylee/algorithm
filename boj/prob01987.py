# 출처: https://www.acmicpc.net/problem/9663
# 문제: N-Queen

import sys

read = sys.stdin.readline


dx = (1, -1, 0, 0)
dy = (0, 0, 1, -1)


def bfs():
    result = 0
    need_visit = set([(0, 0, board[0][0])])

    while need_visit:
        x, y, visited = need_visit.pop()
        result = max(result, len(visited))
        for i, j in zip(dx, dy):
            next_x, next_y = x + i, y + j
            if (
                0 <= next_x < R
                and 0 <= next_y < C
                and board[next_x][next_y] not in visited
            ):
                need_visit.add((next_x, next_y, visited + board[next_x][next_y]))
    return result


R, C = map(int, input().split())
board = [read().rstrip() for _ in range(R)]
print(bfs())
