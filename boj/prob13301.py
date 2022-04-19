dp = [0, 1]

N = int(input())

for i in range(2, N+1):
    dp.append(dp[i-1]+dp[i-2])


print(4*dp[N] + 2*dp[N-1])
