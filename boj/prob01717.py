# 출처: https://www.acmicpc.net/problem/1717
# 문제: 집합의 표현


import sys
sys.setrecursionlimit(100000)
read = sys.stdin.readline

n, m = map(int, read().split())
vertexes = [i for i in range(n+1)]


def find(v):
    global vertexes
    if vertexes[v] == v:
        return v

    vertexes[v] = find(vertexes[v])
    return vertexes[v]


def union(v1, v2):
    global vertexes
    p1 = find(v1)
    p2 = find(v2)

    if p2 < p1:
        vertexes[p1] = p2
    else:
        vertexes[p2] = p1


for _ in range(m):
    op, a, b = map(int, read().split())

    if op == 1:
        print('YES' if find(a) == find(b) else 'NO')

    if op == 0:
        union(a, b)
