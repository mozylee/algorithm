# 출처: https://www.acmicpc.net/problem/2252
# 문제: 줄 세우기


from collections import deque
import sys

read = sys.stdin.readline

n, m = map(int, read().split())
graph = {i: [] for i in range(1, n+1)}
in_degree = {i: 0 for i in range(1, n+1)}
for _ in range(m):
    s, e = map(int, read().split())
    in_degree[e] += 1
    graph[s].append(e)

queue = deque()
for i, v in in_degree.items():
    if v == 0:
        queue.append(i)

result = []
while queue:
    v = queue.popleft()
    result.append(v)

    for next in graph[v]:
        in_degree[next] -= 1

        if in_degree[next] == 0:
            queue.append(next)

print(*result, sep=' ')
