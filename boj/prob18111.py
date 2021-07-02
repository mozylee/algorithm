# 출처: https://www.acmicpc.net/problem/3955
# 문제: 캔디 분배


def get_time_by_height(blocks, h, b):
    time = 0
    for k, v in blocks.most_common():
        if k < h:
            time += (h - k) * v
            b -= (h - k) * v
        elif k > h:
            time += 2 * (k - h) * v
            b += (k - h) * v
    return time


import sys
from collections import Counter

read = sys.stdin.readline

n, m, b = map(int, read().split())

blocks = sum([list(map(int, read().split())) for _ in range(n)], [])
sum_blocks = sum(blocks)
blocks = Counter(blocks)
min_time, height = sys.maxsize, -1

for h in range(257):
    if h * n * m > sum_blocks + b:
        continue
    time = get_time_by_height(blocks, h, b)
    if time < min_time:
        min_time = time
    if time == min_time:
        height = h

print(min_time, height)
