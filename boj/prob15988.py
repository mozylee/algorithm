# 출처: https://www.acmicpc.net/problem/15988
# 문제: 1, 2, 3 더하기 3


nums = [int(input()) for _ in range(int(input()))]

dp = [0, 1, 2, 4]

for i in range(4, max(nums) + 1):
    dp.append(sum(dp[i - j] for j in (1, 2, 3)) % 1000000009)

for num in nums:
    print(dp[num])
