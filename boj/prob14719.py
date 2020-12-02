# 출처: https://www.acmicpc.net/problem/14719
# 문제: 빗물


import sys

read = sys.stdin.readline
h, w = map(int, read().split())
blocks = list(map(int, read().split()))
rain = 0

top = max(blocks)
remove = []
while blocks:
    for i, block in enumerate(blocks):
        if block == top:
            remove.append(i)
    if len(remove) == 1:
        blocks.pop(remove[0])
    
