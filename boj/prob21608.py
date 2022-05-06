N = int(input())
dx = (0, 0, -1, 1)
dy = (-1, 1, 0, 0)


def read():
    line = input().split()
    return int(line[0]), set(map(int, line[1:]))


def sit_down(board, student, candidates, adjacent):
    i, j = candidates.pop()
    board[i][j] = student
    for k in range(4):
        nx = i + dx[k]
        ny = j + dy[k]
        if is_oob(nx, ny):
            continue
        adjacent[nx][ny] -= 1


def init_adjacent():
    adjacent = [[0] * N for _ in range(N)]

    for i in range(N):
        for j in range(N):
            count = 0
            for k in range(4):
                nx = i + dx[k]
                ny = j + dy[k]
                if is_oob(nx, ny):
                    continue
                count += 1
            adjacent[i][j] = count
    return adjacent


def is_oob(x: int, y: int):
    return x < 0 or x >= N or y < 0 or y >= N


def filter_rule1(goods: set, board: list) -> list:
    max_count = 0
    ret = []
    for i in range(N):
        for j in range(N):
            if board[i][j] > 0:
                continue
            count = 0
            for k in range(4):
                nx = i + dx[k]
                ny = j + dy[k]
                if is_oob(nx, ny):
                    continue
                count += 1 if board[nx][ny] in goods else 0
            if count >= max_count:
                if count > max_count:
                    ret.clear()
                max_count = max(max_count, count)
                ret.append((i, j))
    return ret


def filter_rule2(candidates, adjacent) -> list:
    max_count = 0
    ret = []
    for i, j in candidates:
        if adjacent[i][j] >= max_count:
            if adjacent[i][j] > max_count:
                ret.clear()
            max_count = max(max_count, adjacent[i][j])
            ret.append((i, j))
    return ret


def sum_satisfaction(board, goods_dict):
    s_dict = {0: 0, 1: 1, 2: 10, 3: 100, 4: 1000}
    satisfaction = 0
    for i in range(N):
        for j in range(N):
            goods = goods_dict[board[i][j]]
            count = 0
            for k in range(4):
                nx = i + dx[k]
                ny = j + dy[k]
                if is_oob(nx, ny):
                    continue
                count += 1 if board[nx][ny] in goods else 0
            satisfaction += s_dict[count]
    return satisfaction


board = [[0] * N for _ in range(N)]
adjacent = init_adjacent()

goods_dict = {}

for i in range(N*N):
    student, goods = read()
    goods_dict[student] = goods

    candidates = filter_rule1(goods, board)
    if len(candidates) == 1:
        sit_down(board, student, candidates, adjacent)
        continue

    candidates = filter_rule2(candidates, adjacent)
    if len(candidates) == 1:
        sit_down(board, student, candidates, adjacent)
        continue

    candidates = [min(candidates)]
    sit_down(board, student, candidates, adjacent)


print(sum_satisfaction(board, goods_dict))
