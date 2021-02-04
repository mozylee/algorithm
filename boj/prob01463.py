# 출처: https://www.acmicpc.net/problem/1463
# 문제: 1로 만들기


n = int(input())
dp = [0] * (10 ** 6 + 1)

dp[1] = 0
dp[2] = 1

for i in range(3, n + 1):
    comparisons = [dp[i - 1]]
    if i % 2 == 0:
        comparisons.append(dp[i // 2])
    if i % 3 == 0:
        comparisons.append(dp[i // 3])
    dp[i] = min(comparisons) + 1

print(dp[n])
