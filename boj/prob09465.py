# 출처: https://www.acmicpc.net/problem/9465
# 문제: 스티커

import sys

read = sys.stdin.readline

ans = []
for _ in range(int(read())):
    n = int(read())

    sticker = [[0] + list(map(int, read().split())) for _ in range(2)]
    dp = [[0] * (n+1) for _ in range(3)]

    for i in range(1, n+1):
        dp[0][i] = max(dp[0][i-1], dp[1][i-1], dp[2][i-1])
        dp[1][i] = max(dp[0][i-1], dp[2][i-1]) + sticker[0][i]
        dp[2][i] = max(dp[0][i-1], dp[1][i-1]) + sticker[1][i]

    ans.append(max(dp[0][-1], dp[1][-1], dp[2][-1]))

print(*ans, sep="\n")
