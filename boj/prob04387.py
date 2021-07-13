# 출처: https://www.acmicpc.net/problem/4387
# 문제: 별자리 만들기


import sys
from heapq import *


def get_distance(c1, c2):
    return (pow(abs(c1[0]-c2[0]), 2)+pow(abs(c1[1]-c2[1]), 2))**(.5)


def get_graph(coords):
    g = {i: [] for i in range(1, len(coords)+1)}
    for i, c1 in coords.items():
        for j, c2 in coords.items():
            if i != j:
                g[i].append((get_distance(c1, c2), j))
    
    return g


read = sys.stdin.readline

n = int(read())
coords = {i: tuple(map(float, read().split())) for i in range(1, n+1)}
graph = get_graph(coords)

mst_weight = 0
connected = set([1])
need_connected = graph[1]
heapify(need_connected)
while need_connected:
    w, vertex = heappop(need_connected)

    if vertex not in connected:
        connected.add(vertex)
        mst_weight += w
        for next_w, next_v in graph[vertex]:
            if next_v not in connected:
                heappush(need_connected, (next_w, next_v))
print(mst_weight)
