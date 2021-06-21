# 출처: https://www.acmicpc.net/problem/9465
# 문제: 스티커

import sys

read = sys.stdin.readline
for _ in range(int(read())):
    n = int(read())
    array = [list(map(int, read().split())) for _ in range(2)]
    dp = [[0] * n for _ in range(2)]
    for i in range(2):
        dp[i][0] = array[i][0]
        dp[(i + 1) % 2][1] = dp[i][0] + array[(i + 1) % 2][1]

    for j in range(2, n):
        for i in range(2):
            dp[i][j] = (
                max(dp[(i + 1) % 2][j - 1], dp[i][j - 2], dp[(i + 1) % 2][j - 2])
                + array[i][j]
            )
    print(max(dp[0][-1], dp[1][-1]))

