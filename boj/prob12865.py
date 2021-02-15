# 출처: https://www.acmicpc.net/problem/12865
# 문제: 평범한 배낭


import sys

read = sys.stdin.readline
n, k = map(int, read().split())
dp = [[0] * (k + 1) for _ in range(n + 1)]

for i in range(1, n + 1):
    weight, value = map(int, read().split())
    for j in range(1, k + 1):
        if j < weight:
            dp[i][j] = dp[i - 1][j]
        else:
            dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weight] + value)

print(dp[n][k])
