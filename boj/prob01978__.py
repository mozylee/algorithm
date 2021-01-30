# Backjoon Online Judge: https://www.acmicpc.net/problem/1978
# 내용없음

import sys

_ = sys.stdin.readline()
nums = list(filter(lambda x: (x < 4 or x % 2 != 0) and x > 1, map(int, sys.stdin.readline().split())))
result = 0
print(nums)

for n in nums:
    if 1 < n < 4:
        result += 1
        continue
    for i in range(3, int(n ** (1 / 2)) + 1, 2):
        if n % i == 0:
            continue
    result += 1
print(result)
