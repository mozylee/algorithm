# 출처: https://www.acmicpc.net/problem/11726
# 문제: 2xn 타일링


n = int(input())
dp = [0, 1, 2]

for i in range(3, n + 1):
    dp.append(dp[i - 1] + dp[i - 2])

print(dp[n] % 10007)
