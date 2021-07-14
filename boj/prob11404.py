# 출처: https://www.acmicpc.net/problem/11404
# 문제: 플로이드


import sys
read = sys.stdin.readline

MAX_COST = 1e9
n = int(read())
graph = [[MAX_COST]*n for _ in range(n)]

for i in range(n):
    graph[i][i] = 0

for _ in range(int(read())):
    a, b, c = map(int, read().split())
    graph[a-1][b-1] = min(c, graph[a-1][b-1])

for k in range(n):
    for i in range(n):
        for j in range(n):
            graph[i][j] = min(graph[i][j], graph[i][k]+graph[k][j])

for line in graph:
    print(' '.join(str(node) if node < MAX_COST else '0' for node in line))
