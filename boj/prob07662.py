# 출처: https://www.acmicpc.net/problem/7662
# 문제: 이중 우선순위 큐

from sys import stdin
import heapq

for _1 in range(int(stdin.readline())):
    min_heap = []
    max_heap = []
    visited = {}
    for i in range(int(stdin.readline())):
        command, value = stdin.readline().rstrip().split()
        value = int(value)
        if command == 'I':
            heapq.heappush(min_heap, (value, i))
            heapq.heappush(max_heap, (-value, i))
            visited[i] = False
        else:
            if value == 1:
                while max_heap and visited[max_heap[0][1]]:
                    heapq.heappop(max_heap)
                if max_heap:
                    visited[max_heap[0][1]] = True
                    heapq.heappop(max_heap)

            else:
                while min_heap and visited[min_heap[0][1]]:
                    heapq.heappop(min_heap)
                if min_heap:
                    visited[min_heap[0][1]] = True
                    heapq.heappop(min_heap)
        while max_heap and visited[max_heap[0][1]]:
            heapq.heappop(max_heap)
        while min_heap and visited[min_heap[0][1]]:
            heapq.heappop(min_heap)
    if min_heap:
        print(-heapq.heappop(max_heap)[0], heapq.heappop(min_heap)[0])
    else:
        print('EMPTY')
