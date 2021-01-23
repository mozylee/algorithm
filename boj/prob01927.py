# 출처: https://www.acmicpc.net/problem/11279
# 문제: 최소 힙

from sys import stdin
import heapq

heap = []
for _ in range(int(stdin.readline())):
    num = int(stdin.readline())
    if num == 0:
        print(heapq.heappop(heap) if len(heap) else 0)
        continue
    heapq.heappush(heap, num)
