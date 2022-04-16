from collections import deque
import sys


read = sys.stdin.readline


def solution() -> int:
    read()
    values = deque()
    max_gap = 0
    for i, l in enumerate(sorted(map(int, read().split()), reverse=True)):
        if not values:
            values.append(l)
            continue

        if i % 2 == 1:
            max_gap = max(max_gap, abs(l-values[-1]))
            values.append(l)
        else:
            max_gap = max(max_gap, abs(l-values[0]))
            values.appendleft(l)
            
    return max(max_gap, abs(values[-1] - values[0]))


print(*(solution() for _ in range(int(read()))), sep="\n")
