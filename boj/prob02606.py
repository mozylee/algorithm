# 출처: https://www.acmicpc.net/problem/2606
# 문제: 바이러스


import sys
from collections import defaultdict, deque

read = sys.stdin.readline
n = int(read())
m = int(read())

graph = defaultdict(list)


def bfs(graph, start):
    visited = deque()
    need_visited = deque()
    need_visited.append(start)

    while need_visited:
        node = need_visited.popleft()
        if node not in visited:
            visited.append(node)
            need_visited.extend(graph[node])
    return visited


for i in range(m):
    start, end = map(int, read().split())
    graph[start].append(end)
    graph[end].append(start)

print(len(bfs(graph, 1)) - 1)
