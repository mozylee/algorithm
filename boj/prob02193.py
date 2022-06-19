N = int(input())

dp = [[0]*2 for _ in range(N+2)]
dp[1][1] += 1

for i in range(2, N+2):
    dp[i][1] = dp[i-1][0]
    dp[i][0] = sum(dp[i-1])

print(dp[N+1][0])
