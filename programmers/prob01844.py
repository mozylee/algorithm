import sys
from collections import deque

dxy = {0: (1, 0), 1: (0, 1), 2: (-1, 0), 3: (0, -1)}


def solution(maps: list) -> int:
    graph = make_graph(maps)
    distance = sys.maxsize
    visited = set()
    visited.add((0, 0))
    queue = deque([(1, 0, 0)])
    ROWS, COLS = len(maps), len(maps[0])
    end = (ROWS - 1, COLS - 1)
    while queue:
        d, r, c = queue.popleft()
        for i in range(4):
            nr = r + dxy[i][0]
            nc = c + dxy[i][1]
            nd = d + 1
            if is_out_of_bounds(nr, nc, ROWS, COLS) or graph[nr][nc] == 0:
                continue
            if (nr, nc) in visited:
                continue
            if nd >= distance:
                continue
            visited.add((nr, nc))
            if (nr, nc) == end:
                distance = min(distance, nd)
                continue
            queue.append((nd, nr, nc))
    return distance if distance < sys.maxsize else -1


def is_out_of_bounds(r: int, c: int, R: int, C: int) -> bool:
    return not (0 <= r < R and 0 <= c < C)


def make_graph(maps: list) -> dict:
    return {i: {j: maps[i][j] for j in range(len(maps[0]))} for i in range(len(maps))}


test_cases = [
    [
        [1, 0, 1, 1, 1],
        [1, 0, 1, 0, 1],
        [1, 0, 1, 1, 1],
        [1, 1, 1, 0, 1],
        [0, 0, 0, 0, 1],
    ],
    [
        [1, 0, 1, 1, 1],
        [1, 0, 1, 0, 1],
        [1, 0, 1, 1, 1],
        [1, 1, 1, 0, 0],
        [0, 0, 0, 0, 1],
    ],
]
# 11
# -1
for t in test_cases:
    print(solution(t))
