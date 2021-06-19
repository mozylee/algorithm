# 출처: https://www.acmicpc.net/problem/1781
# 문제: 컵라면

import sys
import heapq

read = sys.stdin.readline

problems = sorted([tuple(map(int, read().split())) for _ in range(int(read()))])
heap = []
for deadline, ramen in problems:
    heapq.heappush(heap, ramen)
    if deadline < len(heap):
        heapq.heappop(heap)
print(sum(heap))
