# 출처: https://www.acmicpc.net/problem/1715
# 문제: 카드 정렬하기


import sys
import heapq

read = sys.stdin.readline
queue = []
for _ in range(int(read())):
    heapq.heappush(queue, int(read()))

result = 0
while len(queue) > 1:
    now = heapq.heappop(queue) + heapq.heappop(queue)
    result += now
    heapq.heappush(queue, now)
print(result)
