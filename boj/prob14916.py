N = int(input())
dp = [0, 0, 1, 0, 2, 1] + [0]*N

for i in range(6, N+1):
    dp[i] = min(dp[i-2] if dp[i-2] > 0 else 1e9,
                dp[i-5] if dp[i-5] > 0 else 1e9)+1

print(dp[N] if 0 < dp[N] < 1e9+1 else -1)
