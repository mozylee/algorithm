# Backjoon Online Judge: https://www.acmicpc.net/problem/2751
# 내용없음

from sys import stdin

nums = []
n = int(stdin.readline())
for _ in range(n):
    nums.append(int(stdin.readline()))

print('\n'.join(map(str, sorted(nums))))
