BLOCKS = [
    [[True, True], [True, True]],
    [[True, True, True, True]],
    [[True], [True], [True], [True]],
    [[True], [True, True], [False, True]],
    [[False, True], [True, True], [True]],
    [[False, True, True], [True, True]],
    [[True, True], [False, True, True]],
    [[True, True, True], [False, True]],
    [[False, True], [True, True], [False, True]],
    [[True], [True, True], [True]],
    [[False, True], [True, True, True]],
    [[True, True, True], [True]],
    [[True], [True], [True, True]],
    [[False, False, True], [True, True, True]],
    [[True, True], [False, True], [False, True]],
    [[True, True, True], [False, False, True]],
    [[True, True], [True], [True]],
    [[True], [True, True, True]],
    [[False, True], [False, True], [True, True]],
]

import sys

read = sys.stdin.readline

N, M = map(int, read().split())
board = tuple(tuple(map(int, read().split())) for _ in range(N))


def is_OOB(x, y):
    return x < 0 or x >= N or y < 0 or y >= M


def get_sum(x, y, k):
    sum = 0
    for i in range(len(BLOCKS[k])):
        for j in range(len(BLOCKS[k][i])):
            if is_OOB(x + i, y + j):
                return 0
            sum += board[x + i][y + j] if BLOCKS[k][i][j] else 0
    return sum


max_sum = 0
for i in range(N):
    for j in range(M):
        for k in range(len(BLOCKS)):
            max_sum = max(max_sum, get_sum(i, j, k))

print(max_sum)
