# 출처: https://www.acmicpc.net/problem/1939
# 문제: 중량 제한


import sys
from collections import deque

read = sys.stdin.readline
n, m = map(int, read().split())
graph = {i + 1: [] for i in range(n)}

min_weight = int(1e9)
max_weight = 0
for _ in range(m):
    start, end, weight = map(int, read().split())
    graph[start].append((end, weight))
    graph[end].append((start, weight))
    min_weight = min(min_weight, weight)
    max_weight = max(max_weight, weight)
start, end = map(int, read().split())


def bfs(c):
    visited = [False] * (len(graph.keys()) + 1)
    visited[start] = True
    need_visited = deque([start])

    while need_visited:
        node = need_visited.popleft()
        for next, weight in graph[node]:
            if not visited[next] and weight >= c:
                visited[next] = True
                need_visited.append(next)
    return visited[end]


result = 0
while min_weight <= max_weight:
    mid = (min_weight + max_weight) // 2
    if bfs(mid):
        result = mid
        min_weight = mid + 1
    else:
        max_weight = mid - 1
print(result)
