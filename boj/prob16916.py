import sys


read = sys.stdin.readline

P, S = (read().rstrip() for _ in range(2))

print(1 if S in P else 0)