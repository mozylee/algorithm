# 출처: https://www.acmicpc.net/problem/1774
# 문제: 우주신과의 교감


import sys
from itertools import combinations

read = sys.stdin.readline
parent = dict()
rank = dict()


def find(node):
    # path compression 기법
    if parent[node] != node:
        parent[node] = find(parent[node])
    return parent[node]


def union(node_v, node_u):
    root1 = find(node_v)
    root2 = find(node_u)

    # union-by-rank 기법
    if rank[root1] > rank[root2]:
        parent[root2] = root1
    else:
        parent[root1] = root2
        if rank[root1] == rank[root2]:
            rank[root2] += 1


def make_set(node):
    parent[node] = node
    rank[node] = 0


def kruskal(graph):
    weights = 0

    # 1. 초기화
    for node in graph["vertices"]:
        make_set(node)

    # 2. 간선 weight 기반 sorting
    edges = graph["edges"]
    edges.sort()

    # 3. 간선 연결 (사이클 없는)
    for edge in edges:
        weight, node_v, node_u = edge
        if weight == 0 or find(node_v) != find(node_u):
            union(node_v, node_u)
            weights += weight

    return f"{weights:0.2f}"


n_count, m_count = map(int, read().split())

coords = {i: tuple(map(int, read().split())) for i in range(1, n_count + 1)}
m = {tuple(sorted(map(int, read().split()))) for _ in range(m_count)}
my_graph = {
    "vertices": [i for i in range(1, n_count + 1)],
    "edges": [],
}

for n1, n2 in combinations([i for i in my_graph["vertices"]], 2):
    distance = (
        (pow(coords[n1][0] - coords[n2][0], 2) + pow(coords[n1][1] - coords[n2][1], 2))
        ** 0.5
        if (n1, n2) not in m
        else 0
    )
    my_graph["edges"].append((distance, n1, n2))

print(kruskal(my_graph))
