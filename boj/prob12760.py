from collections import deque
import sys


read = sys.stdin.readline

N, M = map(int, read().split())

players = [deque(sorted(map(int, read().split()))) for _ in range(N)]
scores = {i: 0 for i in range(N)}
for _ in range(M):
    max_score = max(p[-1] for p in players)

    for i, p in enumerate(players):
        scores[i] += 1 if p.pop() == max_score else 0


max_score = max(scores.values())
print(*(i+1 for i in range(N) if scores[i] == max_score), sep=" ")
