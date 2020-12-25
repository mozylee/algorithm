# 출처: https://www.acmicpc.net/problem/1012
# 문제: 유기농 배추

import sys
sys.setrecursionlimit(100000)

def search_near_cabbage(i, j, n, m, field):
    if -1 in (i, j) or n == i or m == j:
        return 0
    if field[i][j][0] != 1 or field[i][j][1]:
        return 0

    field[i][j][1] = True
    left = search_near_cabbage(i - 1, j, n, m, field)
    right = search_near_cabbage(i + 1, j, n, m, field)
    up = search_near_cabbage(i, j + 1, n, m, field)
    down = search_near_cabbage(i, j - 1, n, m, field)
    return 1 + left + right + up + down


for _1 in range(int(input())):
    n, m, k = map(int, input().split())
    field = [[[0, False] for j in range(m)] for i in range(n)]
    for _2 in range(k):
        i, j = map(int, input().split())
        field[i][j][0] = 1

    count_worm = 0
    count_remain_cabbage = k
    for i in range(n):
        for j in range(m):
            if field[i][j][0] == 1 and not field[i][j][1]:
                count_worm += 1
                count_remain_cabbage -= search_near_cabbage(i, j, n, m, field)
            if count_remain_cabbage == 0:
                break
        if count_remain_cabbage == 0:
            break
    print(count_worm)
