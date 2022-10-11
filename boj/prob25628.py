import sys


read = sys.stdin.readline

A, B = map(int, read().split())
print(min(A//2, B))
