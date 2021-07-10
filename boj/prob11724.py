# 출처: https://www.acmicpc.net/problem/11724
# 문제: 연결 요소의 개수


import sys
from collections import deque


read = sys.stdin.readline
n, m = map(int, read().split())

graph = {i: [] for i in range(1, n + 1)}

for _ in range(m):
    u, v = map(int, read().split())
    graph[u].append(v)
    graph[v].append(u)


visited = set()


def bfs(start):
    global visited, graph
    if start in visited:
        return 0

    need_visit = deque([start])
    while need_visit:
        node = need_visit.popleft()
        if node not in visited:
            visited.add(node)
            need_visit.extend(graph[node])
    return 1


result = 0
for node in graph:
    result += bfs(node)

print(result)
