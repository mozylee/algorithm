def get_dp_value(i, j, dp):
    ret = 0
    if j > 0:
        ret += dp[i-1][j-1]
    if j < 9:
        ret += dp[i-1][j+1]

    return ret % 1000000000


N = int(input())
dp = [[0 for i in range(10)] for _ in range(N+1)]
dp[1] = [0] + [1]*9
for i in range(2, N+1):
    for j in range(10):
        dp[i][j] = get_dp_value(i, j, dp)

print(sum(dp[N])% 1000000000)
