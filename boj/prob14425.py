import sys


read = sys.stdin.readline

N,M = map(int,read().split())
s = set(read().rstrip() for _ in range(N))

print(sum(1 if read().rstrip() in s else 0 for _ in range(M)))