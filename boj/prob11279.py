# 출처: https://www.acmicpc.net/problem/11279
# 문제: 최대 힙

from sys import stdin
import heapq

heap = []
for _ in range(int(stdin.readline())):
    num = int(stdin.readline())
    if num == 0:
        print(heapq.heappop(heap)[1] if len(heap) else 0)
        continue
    heapq.heappush(heap, (-num, num))
