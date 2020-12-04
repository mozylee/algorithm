# 출처: https://www.acmicpc.net/problem/11866
# 문제: 요세푸스 문제 0


import sys
from collections import deque

n, k = map(int, sys.stdin.readline().split())
josephus = list()
nums = deque(i for i in range(1, n + 1))

while nums:
    nums.rotate(-(k - 1))
    josephus.append(nums.popleft())

print(f'<{", ".join(str(i) for i in josephus)}>')
