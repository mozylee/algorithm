# 출처: https://www.acmicpc.net/problem/18870
# 문제: 좌표 압축

from sys import stdin

_ = stdin.readline()
nums = list(map(int, stdin.readline().split()))
nums_dict = {num: str(i) for i, num in enumerate(sorted(set(nums)))}
print(' '.join(nums_dict[num] for num in nums))
