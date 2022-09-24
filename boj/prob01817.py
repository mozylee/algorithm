
from collections import deque
import sys


read = sys.stdin.readline

N, M = map(int, read().split())

if N == 0:
    print(0)
    exit(0)

books = deque(map(int, read().split()))

count = 0
while books:
    box = 0
    while books and box < M:
        if books[0]+box > M:
            break
        box += books.popleft()

    count += 1

print(count)