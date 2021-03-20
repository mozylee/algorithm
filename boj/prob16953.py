# 출처: https://www.acmicpc.net/problem/16953
# 문제: A → B


from collections import deque, defaultdict


def bfs(s, d):
    visited = defaultdict(bool)
    need_visit = deque([(s, 1)])

    while need_visit:
        node, count = need_visit.popleft()
        if node > d:
            continue
        elif node == d:
            return count
        if not visited[node]:
            visited[node] = True
            for i in (node * 10 + 1, node * 2):
                need_visit.append((i, count + 1))
    return -1


a, b = map(int, input().split())

print(bfs(a, b))
