# 출처: https://www.acmicpc.net/problem/5719
# 문제: 거의 최단 경로


from collections import deque
import heapq
import sys

read = sys.stdin.readline
INF = 1e9


def delete_path(s, d):
    need_visit = deque([s])
    while need_visit:
        node = need_visit.popleft()
        if node == d:
            continue
        for next, weight in reversed_graph[node].items():
            if distances[next] + weight == distances[node]:
                if node in graph[next]:
                    del graph[next][node]
                    need_visit.append(next)


def dijkstra(start):
    queue = []
    heapq.heappush(queue, (distances[start], start))
    while queue:
        current_distance, current_vertex = heapq.heappop(queue)
        if distances[current_vertex] < current_distance:
            continue
        for adjacent, weight in graph[current_vertex].items():
            distance = current_distance + weight
            if distance < distances[adjacent]:
                distances[adjacent] = distance
                heapq.heappush(queue, (distance, adjacent))


while True:
    n, m = map(int, read().split())
    if n == m == 0:
        break
    s, d = map(int, read().split())
    graph = {i: dict() for i in range(n)}
    reversed_graph = {i: dict() for i in range(n)}
    for __ in range(m):
        u, v, p = map(int, read().split())
        graph[u][v] = p
        reversed_graph[v][u] = p
    distances = {vertex: INF for vertex in graph}
    distances[s] = 0
    dijkstra(s)
    delete_path(d, s)
    distances = {vertex: INF for vertex in graph}
    distances[s] = 0
    dijkstra(s)
    print(distances[d] if distances[d] < INF else -1)
