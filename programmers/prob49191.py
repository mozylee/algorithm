def floyd_washall(n, graph):
    for k in range(n):
        for i in range(n):
            for j in range(n):
                if not graph[i][j]:
                    graph[i][j] = graph[i][k] and graph[k][j]
    for i in range(n):
        graph[i][i] = True
    return graph


def solution(n, results):
    map = [[False]*n for _ in range(n)]
    for winner, loser in results:
        map[winner-1][loser-1] = True

    map = floyd_washall(n, map)
    count = 0
    for i in range(n):
        is_ok = True
        for j in range(n):
            if i == j:
                continue
            if map[i][j] or map[j][i]:
                continue
            is_ok = False
            break
        count = count+1 if is_ok else count
    return count


print(solution(5, [[4, 3], [4, 2], [3, 2], [1, 2], [2, 5]]))
