# 출처: https://www.acmicpc.net/problem/3055
# 문제: 탈출

import sys
from collections import deque

read = sys.stdin.readline

move = [(0, 1), (0, -1), (1, 0), (-1, 0)]
waters = deque()
forest = []

r, c = map(int, read().split())
s, d = -1, -1

for i in range(r):
    string = read().rstrip()
    forest.append(list(string))
    if "S" in string:
        s = (i, string.find("S"), 0)
    if "D" in string:
        d = (i, string.find("D"))
    for j, char in enumerate(string):
        if char == "*":
            waters.append((i, j))


def bfs():
    global forest, move, r, c, s, d
    visited = set()
    need_visit = deque([s])

    while need_visit or waters:
        length = len(waters)
        while length:
            x, y = waters.popleft()
            length -= 1
            for dx, dy in move:
                next_x, next_y = x + dx, y + dy
                if (
                    0 <= next_x < r
                    and 0 <= next_y < c
                    and forest[next_x][next_y] not in ("X", "D", "*")
                ):
                    forest[next_x][next_y] = "*"
                    waters.append((next_x, next_y))

        length = len(need_visit)
        while length:
            x, y, time = need_visit.popleft()
            if (x, y) not in visited:
                visited.add((x, y))
                for dx, dy in move:
                    next_x, next_y = x + dx, y + dy
                    if (
                        0 <= next_x < r
                        and 0 <= next_y < c
                        and forest[next_x][next_y] not in ("X", "*")
                    ):
                        if (next_x, next_y) == d:
                            return time + 1
                        need_visit.append((next_x, next_y, time + 1))
            length -= 1
    return "KAKTUS"


print(bfs())
