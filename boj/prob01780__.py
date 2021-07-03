# 출처: https://www.acmicpc.net/problem/1780
# 문제: 종이의 개수


import sys

read = sys.stdin.readline
sys.setrecursionlimit(1000000)

paper = {
    i: {j: num for j, num in enumerate(map(int, read().split()))}
    for i in range(int(read()))
}

values = {i: 0 for i in range(-1, 2)}


def check_square(i, j, size):
    criteria = paper[i][j]
    if size == 1:
        values[criteria] += 1
        return

    for _i in range(size):
        for _j in range(size):
            if paper[i + _i][j + _j] != criteria:
                small_size = size // 3
                for x in range(3):
                    for y in range(3):
                        check_square(i + small_size * x, j + small_size * y, small_size)
                return

    values[criteria] += 1
    return


check_square(0, 0, len(paper.keys()))
print(*values.values(), sep="\n")

