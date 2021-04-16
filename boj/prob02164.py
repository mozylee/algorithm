# 출처: https://www.acmicpc.net/problem/2164
# 문제: 카드2


import sys
from collections import deque

n = int(sys.stdin.readline())
nums = deque([i for i in range(n, 0, -1)])
trial = 1

while len(nums) > 1:
    nums.pop() if trial % 2 == 1 else nums.appendleft(nums.pop())
    trial += 1

print(nums.pop())
