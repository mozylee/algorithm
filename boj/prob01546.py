# Backjoon Online Judge: https://www.acmicpc.net/problem/1546
# 내용없음

import sys

n = int(sys.stdin.readline().strip())
nums = list(map(int, sys.stdin.readline().split()))

print(sum(nums) / max(nums) * 100 / n)
