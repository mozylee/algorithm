from heapq import heappush, heappop
import sys


def solution(N: int, road: list, K: int) -> int:
    graph = make_graph(N, road)
    return len(list(filter(lambda x: x <= K, dijkstra(graph).values())))


def dijkstra(graph: dict) -> dict:
    distances = {i: sys.maxsize for i in graph.keys()}
    distances[1] = 0
    heap = []
    heappush(heap, (distances[1], 1))
    while heap:
        current_distance, current_node = heappop(heap)
        if distances[current_node] < current_distance:
            continue
        for next_node, next_distance in graph[current_node].items():
            total_distance = current_distance + next_distance
            if total_distance < distances[next_node]:
                distances[next_node] = total_distance
                heappush(heap, (total_distance, next_node))
    return distances


def make_graph(N: int, road: list) -> dict:
    graph = {i: {} for i in range(1, N + 1)}
    for s, e, d in road:
        graph[s][e] = d if e not in graph[s] else min(d, graph[s][e])
        graph[e][s] = d if s not in graph[e] else min(d, graph[e][s])
    return graph


test_cases = [
    [5, [[1, 2, 1], [2, 3, 3], [5, 2, 2], [1, 4, 2], [5, 3, 1], [5, 4, 2]], 3],
    [
        6,
        [[1, 2, 1], [1, 3, 2], [2, 3, 2], [3, 4, 3], [3, 5, 2], [3, 5, 3], [5, 6, 1]],
        4,
    ],
]
# 4
# 4

for n, r, k in test_cases:
    print(solution(n, r, k))
