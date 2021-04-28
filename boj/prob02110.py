# 출처: https://www.acmicpc.net/problem/2110
# 문제: 공유기 설치


import sys

read = sys.stdin.readline
n, c = map(int, read().split())
nums = sorted([int(read()) for _ in range(n)])
min_index, max_index = 1, nums[-1] - nums[0]
result = 0
while min_index <= max_index:
    gap = (max_index + min_index) // 2
    index = nums[0]
    count = 1
    for i in range(1, len(nums)):
        if nums[i] >= index + gap:
            index = nums[i]
            count += 1
    if c <= count:
        min_index = gap + 1
        result = gap
    else:
        max_index = gap - 1
print(result)
