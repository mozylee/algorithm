# 출처: https://www.acmicpc.net/problem/1753
# 문제: 최단경로


import sys
import heapq

read = sys.stdin.readline
INF = sys.maxsize

v, e = map(int, read().split())
graph = {i: [] for i in range(v)}
distance = [INF for i in range(v)]
start = int(read()) - 1
distance[start] = 0

for _ in range(e):
    u, v, w = map(int, read().split())
    graph[u - 1].append((w, v - 1))

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

for d in distance:
    print(d if d < INF else 'INF')
