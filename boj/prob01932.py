# 출처: https://www.acmicpc.net/problem/1932
# 문제: 정수삼각형

from sys import stdin

triangle = [list(map(int, stdin.readline().split())) for _ in range(int(stdin.readline()))]
dp = [[0] * (i + 1) for i in range(len(triangle))]
dp[0][0] = triangle[0][0]
for i in range(1, len(dp)):
    for j in range(len(dp[i])):
        left = right = 0
        if j != 0:
            left = dp[i - 1][j - 1]
        if j < len(dp[i]) - 1:
            right = dp[i - 1][j]
        dp[i][j] = max(left, right) + triangle[i][j]
print(max(dp[-1]))
