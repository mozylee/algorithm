from collections import deque


N, M = map(int, input().split())


def is_oob(x, y):
    return x < 0 or x >= N or y < 0 or y >= M


def can_down(x, y, board: list, cross: list):
    for i in range(len(cross)):
        for j in range(len(cross[i])):
            if is_oob(x+i, y+j):
                return False
            if cross[i][j] and not board[x+i][y+j]:
                return False
    return True


def down(x, y, board: list, cross: list):
    for i in range(len(cross)):
        for j in range(len(cross[i])):
            if cross[i][j]:
                board[x+i][y+j] = False


board_origin = [[c == "#" for c in input()] for _ in range(N)]


def deepcopy():
    return [[e for e in line] for line in board_origin]


cross = {i: [[False]*i + [True] + [False] *
             i for _ in range(i)] +
             [[True]*(2*i+1)]+
             [[False]*i + [True] + [False] *
             i for _ in range(i)]
        for i in range(8)}
cross_area = {i: 4*i+1 for i in range(8)}

max_area = 0
for k1 in cross.keys():
    for i in range(N):
        for j in range(M):
            if can_down(i, j, board_origin, cross[k1]):
                board_copy = deepcopy()
                down(i, j, board_copy, cross[k1])
                for k2 in cross.keys():
                    for i2 in range(N):
                        for j2 in range(M):
                            if can_down(i2, j2, board_copy, cross[k2]):
                                max_area = max(
                                    max_area, cross_area[k1] * cross_area[k2])
print(max_area)
