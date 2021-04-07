# 출처: https://www.acmicpc.net/problem/2775
# 문제: 부녀회장이 될테야


import sys

read = sys.stdin.readline
dp = [[i for i in range(1, 14 + 1)] for _ in range(14 + 1)]
for i in range(1, 14 + 1):
    for j in range(1, 14):
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
for _ in range(int(read())):
    k, n = int(read()), int(read())
    print(dp[k][n - 1])
