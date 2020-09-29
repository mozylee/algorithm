# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/42628
# 문제: 이중우선순위큐

import heapq
from collections import deque


def solution(operations):
    min_h, max_h = [], []
    length = 0

    operations = deque(operations)
    while operations:
        operation, value = operations.popleft().split()
        if operation == 'I':
            length += 1
            heapq.heappush(min_h, int(value))
            heapq.heappush(max_h, -int(value))
        elif length > 0:
            length -= 1
            if value == '1':
                heapq.heappop(max_h)
            else:
                heapq.heappop(min_h)

        if length <= 0:
            min_h, max_h = [], []
    return [-max_h[0], min_h[0]] if length > 0 else [0, 0]


print(solution(["I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"]))
