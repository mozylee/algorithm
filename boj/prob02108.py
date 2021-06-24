# 출처: https://www.acmicpc.net/problem/2108
# 문제: 통계학


import sys
from collections import Counter


read = sys.stdin.readline

n = int(read())

nums = sorted([int(read()) for _ in range(n)])
counter = Counter(nums).most_common()

print(round(sum(nums) / n))
print(nums[n // 2])

if len(counter) <= 1:
    print(counter[0][0])
elif counter[0][1] > counter[1][1]:
    print(counter[1][0])
else:
    print(counter[0][0])
print(max(nums) - min(nums))
