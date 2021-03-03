# 출처: https://www.acmicpc.net/problem/11053
# 문제: 가장 긴 증가하는 부분 수열

from sys import stdin

read = stdin.readline
read()
nums = list(map(int, read().split()))
dp = [1] * (len(nums) + 1)


for i in range(1, len(nums)):
    for j in range(0, i):
        if nums[i] > nums[j]:
            dp[i] = max(dp[i], dp[j] + 1)
print(max(dp))
