# 출처: https://www.acmicpc.net/problem/9461
# 문제: 파도반 수열


from sys import stdin

dp = [0, 1, 1]
nums = [int(stdin.readline()) for _ in range(int(stdin.readline()))]
for i in range(3, max(nums) + 1):
    dp.append(dp[i - 2] + dp[i - 3])

print('\n'.join(str(dp[num]) for num in nums))
