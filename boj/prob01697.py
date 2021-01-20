# 출처: https://www.acmicpc.net/problem/1697
# 문제: 술래잡기


from collections import deque, defaultdict

n, k = map(int, input().split())


def bfs(n, k):
    visited = defaultdict(int)
    queue = deque()
    queue.append(n)
    while queue:
        num = queue.popleft()

        if num == k:
            return visited[num]

        for next in (num - 1, num + 1, num * 2):
            if 0 <= next <= 100000 and visited[next] == 0:
                visited[next] = visited[num] + 1
                queue.append(next)
    return -1


print(bfs(n, k))
