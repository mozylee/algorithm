# Backjoon Online Judge: https://www.acmicpc.net/problem/10989
# 내용없음

from sys import stdin
from collections import defaultdict

nums = defaultdict(int)
for _ in range(int(stdin.readline())):
    nums[int(stdin.readline())] += 1

for i in sorted(nums.keys()):
    for _ in range(nums[i]):
        print(i)
