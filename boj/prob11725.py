# 출처: https://www.acmicpc.net/problem/11725
# 문제: 트리의 부모 찾기

import sys
from collections import deque

read = sys.stdin.readline


def bfs():
    visited = set()
    need_visit = deque([1])

    while need_visit:
        now = need_visit.popleft()

        if now not in visited:
            visited.add(now)
            for next in graph[now]:
                if next != 1 and not parent[next]:
                    parent[next] = now
                    need_visit.append(next)


n = int(read())
graph = {i + 1: [] for i in range(n)}

for i in range(n - 1):
    node1, node2 = map(int, read().split())
    graph[node1].append(node2)
    graph[node2].append(node1)

parent = {i: None for i in range(2, n + 1)}
bfs()

for i in range(2, n + 1):
    print(parent[i])

