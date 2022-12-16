N = int(input())
dp = [0] + [1]*N

for i in range(2,  N+1):
    dp[i] = 5
    for j in range(1, int(i ** (1 / 2)) + 1):
        dp[i] = min(dp[i], dp[i - j ** 2])
    dp[i] += 1

print(dp[N])
