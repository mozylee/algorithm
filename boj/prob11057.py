def get_dp_value(i, j, dp):
    ret = dp[i-1][j] + (dp[i][j-1] if j > 0 else 0)
    return ret % 10007


N = int(input())
dp = [[0 for i in range(10)] for _ in range(N+1)]
dp[1] = [1]*10
for i in range(2, N+1):
    for j in range(10):
        dp[i][j] = get_dp_value(i, j, dp)

print(sum(dp[N]) % 10007)
