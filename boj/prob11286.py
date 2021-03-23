# 출처: https://www.acmicpc.net/problem/11286
# 문제: 절댓값 힙


from sys import stdin
import heapq

heap = []
for _ in range(int(stdin.readline())):
    n = int(stdin.readline())
    if n != 0:
        heapq.heappush(heap, (abs(n), n))
        continue

    if not heap:
        print(0)
        continue
    mins = [heapq.heappop(heap)]
    key = mins[0][0]
    while heap and key == heap[0][0]:
        mins.append(heapq.heappop(heap))
    mins.sort(key=lambda x: x[1], reverse=True)
    print(mins.pop()[1])
    for item in mins:
        heapq.heappush(heap, item)
