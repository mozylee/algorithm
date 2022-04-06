import sys


read = sys.stdin.readline

N = int(read())
values = sorted(map(int, read().split()))
print(values[N//2 + (0 if N % 2 == 1 else -1)])
