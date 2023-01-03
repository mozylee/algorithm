import sys

read = sys.stdin.readline

a, d, k = map(int, read().split())

ans = (k-a)/d
print(int(ans)+1 if ans.is_integer() and ans >= 0 else "X")
