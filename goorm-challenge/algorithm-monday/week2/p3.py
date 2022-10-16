import sys


read = sys.stdin.readline

N,k = map(int, read().split())
students = sorted(tuple(read().rstrip().split()) for _ in range(N))

print(*students[k-1])