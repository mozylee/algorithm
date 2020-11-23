# 출처: https://www.acmicpc.net/problem/1325
# 문제: 효율적인 해킹

import sys
from collections import defaultdict, deque

read = sys.stdin.readline


def bfs(start_node):
    visited = defaultdict(bool)
    need_visit = deque([start_node])
    hackable = 0

    while need_visit:
        node = need_visit.popleft()
        if not visited[node]:
            hackable += 1
            visited[node] = True
            need_visit.extend(graph[node])

    return hackable


n, m = map(int, read().split())
graph = defaultdict(deque)
for _ in range(m):
    a, b = map(int, read().split())
    graph[b].append(a)

max_value = -1
result = []
for i in range(n):
    hackable = bfs(i + 1)
    if hackable > max_value:
        result = [i + 1]
        max_value = hackable
    elif hackable == max_value:
        result.append(i + 1)

print(*result)
