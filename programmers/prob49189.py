# 출처: https://programmers.co.kr/learn/courses/30/lessons/49189
# 문제: 가장 먼 노드

from collections import deque


def bfs(graph):
    visited = set()
    need_visit = deque()
    edges = {vertex: 0 for vertex in graph}
    need_visit.append((1, 0))
    max_edge = 0
    count = 0

    while need_visit:
        node, count_edge = need_visit.popleft()
        if node not in visited:
            visited.add(node)
            edges[node] = count_edge + 1
            if max_edge == edges[node]:
                count += 1
            elif max_edge < edges[node]:
                max_edge = edges[node]
                count = 1
            for next in graph[node]:
                need_visit.append((next, edges[node]))
    return count


def solution(n, edge):
    graph = {i + 1: [] for i in range(n)}
    for s, e in edge:
        graph[s].append(e)
        graph[e].append(s)
    return bfs(graph)


print(solution(6, [[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]))

