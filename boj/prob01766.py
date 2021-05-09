# 출처: https://www.acmicpc.net/problem/1766
# 문제: 문제집


import sys
import heapq


read = sys.stdin.readline
n, m = map(int, read().split())
result = []
priors = [[] for i in range(n + 1)]
indegrees = [0] * (n + 1)

for _ in range(m):
    prior, problem = map(int, read().split())
    priors[prior].append(problem)
    indegrees[problem] += 1

queue = []
for i in range(1, n + 1):
    if indegrees[i] == 0:
        heapq.heappush(queue, i)

while queue:
    i = heapq.heappop(queue)
    result.append(i)

    for problem in priors[i]:
        indegrees[problem] -= 1
        if indegrees[problem] == 0:
            heapq.heappush(queue, problem)

print(" ".join(map(str, result)))
