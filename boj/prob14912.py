import sys


read = sys.stdin.readline

n, d = map(int, read().split())

ans = 0
for i in range(n+1):
    while i > 0:
        ans += 1 if i % 10 == d else 0
        i //= 10

print(ans)
