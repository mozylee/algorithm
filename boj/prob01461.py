# 출처: https://www.acmicpc.net/problem/1461
# 문제: 도서관

import heapq
import sys

read = sys.stdin.readline

n, m = map(int, read().split())
positive, negative = list(), list()

max_book = 0
for book in map(int, read().split()):
    if book > 0:
        max_book = max(max_book, book)
        heapq.heappush(positive, -book)
    else:
        max_book = max(max_book, -book)
        heapq.heappush(negative, book)

result = 0
while positive:
    result += heapq.heappop(positive)
    for _ in range(m - 1):
        if not positive:
            break
        heapq.heappop(positive)

while negative:
    result += heapq.heappop(negative)
    for _ in range(m - 1):
        if not negative:
            break
        heapq.heappop(negative)

print(-result * 2 - max_book)
