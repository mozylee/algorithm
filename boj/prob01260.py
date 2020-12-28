# 출처: https://www.acmicpc.net/problem/1260
# 문제: DFS와 BFS


import sys
from collections import deque


def bfs(graph, start):
    visited = list()
    need_visit = deque()
    need_visit.append(start)
    while need_visit:
        node = need_visit.popleft()
        if node not in visited:
            visited.append(node)
            need_visit.extend(graph[node])

    return " ".join(str(node) for node in visited)


def dfs(graph, start):
    visited = list()
    need_visit = deque()
    need_visit.append(start)
    while need_visit:
        node = need_visit.pop()
        if node not in visited:
            visited.append(node)
            need_visit.extend(reversed(graph[node]))
    return " ".join(str(node) for node in visited)


n, m, start = map(int, sys.stdin.readline().split())
graph = {i: [] for i in range(1, n + 1)}

for _ in range(m):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(1, n + 1):
    graph[i].sort()

print(dfs(graph, start))
print(bfs(graph, start))
