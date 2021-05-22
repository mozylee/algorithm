# 출처: https://www.acmicpc.net/problem/2407
# 문제: 조합


n, m = map(int, input().split())
dp = [[0] * (m + 1) for _ in range(n + 1)]
dp[0][0] = 1
dp[1][0] = 1
dp[0][1] = 1
dp[1][1] = 1

for i in range(1, n + 1):
    for j in range(0, m + 1):
        if j > i:
            break
        dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) if not (j == 0 or i == j) else 1
print(dp[n][m])
