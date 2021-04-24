# 출처: https://www.acmicpc.net/problem/1916
# 문제: 최소비용 구하기


import sys
import heapq

read = sys.stdin.readline
INF = sys.maxsize

v = int(read())
e = int(read())
graph = {i: [] for i in range(v)}
distance = [INF for i in range(v)]

for _ in range(e):
    u, v, w = map(int, read().split())
    graph[u - 1].append((w, v - 1))

start, end = map(lambda x: int(x) - 1, read().split())
heap = []
heapq.heappush(heap, (0, start))
distance[start] = 0

while heap:
    now_w, now = heapq.heappop(heap)

    if distance[now] < now_w:
        continue

    for w, node in graph[now]:
        w += now_w
        if w < distance[node]:
            distance[node] = w
            heapq.heappush(heap, (w, node))

print(distance[end])
