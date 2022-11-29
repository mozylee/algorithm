from collections import deque
import sys


read = sys.stdin.readline


def is_same_grade(c1: tuple, c2: tuple) -> bool:
    return c1[1] == c2[1] and c1[2] == c2[2] and c1[3] == c2[3]


N, K = map(int, read().split())

countries = deque(sorted((tuple(map(int, read().split()))
                  for _ in range(N)), key=lambda x: (-x[1], -x[2], -x[3])))

before = (0, 1e9, 1e9, 1e9)
higher, same = 0, 1
grades = {}

while countries:
    top = countries.popleft()
    if not is_same_grade(before, top):
        higher += same
        same = 0
        
    before = top
    grades[top[0]] = higher
    same += 1

print(grades[K])
