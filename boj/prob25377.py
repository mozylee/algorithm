import sys


def read_and_parse(): return tuple(map(int, sys.stdin.readline().split()))


min_time = 1e9
for _ in range(read_and_parse()[0]):
    A, B = read_and_parse()
    if A <= B:
        min_time = min(min_time, B)

print(min_time if min_time<1e9 else -1)
