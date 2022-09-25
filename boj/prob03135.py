import sys


read = sys.stdin.readline

A, B = map(int, read().split())
min_gap = abs(A-B)

for favorite in (int(read()) for _ in range(int(read()))):
    min_gap = min(min_gap, abs(favorite-B)+1)

print(min_gap)
