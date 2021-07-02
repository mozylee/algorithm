# 출처: https://www.acmicpc.net/problem/2748
# 문제: 피보나치 수 2


n = int(input())

dp = [i for i in range(2)]

for i in range(2, n + 1):
    dp.append(dp[i - 1] + dp[i - 2])
print(dp[n])
