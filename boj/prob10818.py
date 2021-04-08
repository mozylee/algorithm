# Backjoon Online Judge: https://www.acmicpc.net/problem/10818
# 내용없음

import sys

_ = int(sys.stdin.readline())
nums = list(map(int, sys.stdin.readline().split()))

print(min(nums), max(nums))
