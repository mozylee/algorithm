# 출처: https://www.acmicpc.net/problem/11438
# 문제: LCA 2


import sys
from collections import deque
read = sys.stdin.readline

# log10(100000) < 21
LENGTH = 21
n = int(read())

graph = {i: [] for i in range(1, n+1)}

for _ in range(n-1):
    a, b = map(int, read().split())
    graph[a].append(b)
    graph[b].append(a)

parent = {i: {j: 1 for j in range(LENGTH)} for i in range(1, n+1)}
depth = {i: 0 for i in range(1, n+1)}

visited = set()
need_visited = deque([(1, 0)])

while need_visited:
    node, d = need_visited.popleft()
    if node not in visited:
        visited.add(node)

        for next in graph[node]:
            if next not in visited:
                depth[next] = d+1
                parent[next][0] = node
                need_visited.append((next, depth[next]))

for j in range(1, LENGTH):
    for i in range(1, n+1):
        parent[i][j] = parent[parent[i][j-1]][j-1]

for _ in range(int(read())):
    a, b = map(int, read().split())
    if depth[a] > depth[b]:
        a, b = b, a

    for i in range(LENGTH - 1, -1, -1):
        if depth[b]-depth[a] >= 2**i:
            b = parent[b][i]

    if a == b:
        print(a)
        continue

    for i in range(LENGTH - 1, -1, -1):
        if parent[a][i] != parent[b][i]:
            a = parent[a][i]
            b = parent[b][i]
    print(parent[a][0])
