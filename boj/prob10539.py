# 출처: https://www.acmicpc.net/problem/10539
# 문제: 수빈이와 수열


import sys

read = sys.stdin.readline

_ = read()
nums = [num * (i + 1) for i, num in enumerate(map(int, read().split()))]

result = [nums[0]]

for i, num in enumerate(nums):
    if i == 0:
        continue

    result.append(num - nums[i - 1])

print(*result, sep=" ")
