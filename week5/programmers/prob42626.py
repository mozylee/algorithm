# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/42626
# 문제: 더 맵게

import heapq


def solution(scoville, K):
    heapq.heapify(scoville)

    time = 0
    food = heapq.heappop(scoville)
    while food < K:
        if scoville:
            food = heapq.heappushpop(scoville, food + (heapq.heappop(scoville)) * 2)
        else:
            time = -1
            break
        time += 1
    return time


print(solution([1, 1, 1], 8))
