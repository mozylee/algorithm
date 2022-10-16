import sys


read = sys.stdin.readline


def check_coord(x, y, n):
    return 1 if 0 <= x < n and 0 <= y < n else 0


dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

n, k = map(int, read().split())

ans = 0
for _ in range(k):
    x, y = map(int, read().split())
    ans += 1 + sum(check_coord(x+ddx-1, y+ddy-1, n) for ddx, ddy in zip(dx, dy))

print(ans)
