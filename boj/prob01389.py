import sys

MAX = sys.maxsize


def floyd_warshall(graph: list) -> list:
    length = len(graph)
    for k in range(length):
        for i in range(length):
            for j in range(length):
                graph[i][j] = graph[j][i] = min(graph[i][j], graph[i][k] + graph[k][j])
    return [sum(filter(lambda x: x < MAX, distances)) for distances in graph]


def get_min_index(values: list) -> int:
    min_value = min(values)
    return min(filter(lambda x: values[x] == min_value, range(len(values))))


read = sys.stdin.readline

N, M = map(int, read().split())
graph = [[MAX] * (N) for _ in range(N)]
for i in range(N):
    graph[i][i] = 0

for _ in range(M):
    user1, user2 = map(int, read().split())
    user1 -= 1
    user2 -= 1
    graph[user1][user2] = graph[user2][user1] = 1

distances = floyd_warshall(graph)
print(get_min_index(distances) + 1)
