# 출처: https://www.acmicpc.net/problem/1922
# 문제: 네트워크 연결


from collections import defaultdict
import heapq
import sys
sys.setrecursionlimit(100000)
read = sys.stdin.readline

n = int(read())
m = int(read())
edges = []
for _ in range(m):
    v1, v2, w = map(int, read().split())
    edges.append((w, v1, v2))


def prim(start):
    global edges
    mst_weight = 0
    graph = defaultdict(list)

    for w, v1, v2 in edges:
        graph[v1].append((w, v1, v2))
        graph[v2].append((w, v2, v1))

    connected = set([start])
    need_connected = graph[start]
    heapq.heapify(need_connected)

    while need_connected:
        w, _, e = heapq.heappop(need_connected)

        if e not in connected:
            connected.add(e)
            mst_weight += w

            for edge in graph[e]:
                if edge[2] not in connected:
                    heapq.heappush(need_connected, edge)

    return mst_weight


print(prim(edges[0][1]))
