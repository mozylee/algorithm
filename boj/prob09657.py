N = int(input())

dp = [0, True, False, True, True]

for i in range(5, N+1):
    dp.append(not dp[i-1] or not dp[i-3] or not dp[i-4])

print("SK" if dp[N] else "CY")
