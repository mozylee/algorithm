# 출처: https://www.acmicpc.net/problem/1904
# 문제: 01타일


n = int(input())
dp = [0, 1, 2]
for i in range(3, n + 1):
    dp.append((dp[i - 1] + dp[i - 2]) % 15746)
print(dp[n])
