import sys


read = sys.stdin.readline

N = int(read())

min_end, max_start = 1e9, 0
for _ in range(N):
    s, e = map(int, read().split())
    min_end = min(min_end, e)
    max_start = max(max_start, s)

print(max(max_start-min_end, 0))
