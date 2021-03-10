# Backjoon Online Judge: https://www.acmicpc.net/problem/2562
# 내용없음

import sys

nums = list()
for i in range(9):
    nums.append(int(sys.stdin.readline().strip()))

max_num = max(nums)
print(max_num)
print(nums.index(max_num) + 1)
