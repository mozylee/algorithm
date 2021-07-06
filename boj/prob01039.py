# 출처: https://www.acmicpc.net/problem/1039
# 문제: 교환


def get_swapped(string, i, j):
    arr = list(string)
    arr[i], arr[j] = arr[j], arr[i]
    return "".join(arr)


import sys
from collections import deque

read = sys.stdin.readline

n, k = read().rstrip().split()
k = int(k)


def bfs(limit):
    need_visit = deque()
    visited = set()
    need_visit.append((n, 0))
    max_result = -1

    while need_visit:
        length = len(need_visit)
        visited = set()
        while length:
            nums, time = need_visit.popleft()
            length -= 1
            if time == limit:
                max_result = max(max_result, int(nums))
                continue
            for i in range(len(nums)):
                for j in range(len(nums)):
                    if i != j:
                        swapped = get_swapped(nums, i, j)
                        if swapped not in visited and swapped[0] != "0":
                            visited.add(swapped)
                            need_visit.append((swapped, time + 1))

    return max_result


print(bfs(k))
