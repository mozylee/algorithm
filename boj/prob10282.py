# 출처: https://www.acmicpc.net/problem/10282
# 문제: 해킹


import sys
from heapq import *

read = sys.stdin.readline


def dijkstra(graph, start):
    distances = {vertex: [float("inf"), start] for vertex in graph}
    distances[start] = [0, start]
    queue = []
    heappush(queue, [distances[start][0], start])

    while queue:
        current_distance, current_vertex = heappop(queue)
        if distances[current_vertex][0] < current_distance:
            continue
        for adjacent, weight in graph[current_vertex].items():
            distance = current_distance + weight
            if distance < distances[adjacent][0]:
                distances[adjacent] = [distance, current_vertex]
                heappush(queue, [distance, adjacent])

    filtered_distances = list(
        filter(lambda x: x != float("inf"), map(lambda x: x[0], distances.values()))
    )
    return len(filtered_distances), max(filtered_distances)


for _ in range(int(read())):
    n, d, c = map(int, read().split())
    graph = {i: {} for i in range(1, n + 1)}
    for __ in range(d):
        a, b, s = map(int, read().split())
        graph[b][a] = s
    print(*dijkstra(graph, c))
