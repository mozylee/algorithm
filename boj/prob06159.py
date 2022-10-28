from collections import deque
import sys


read = sys.stdin.readline

N, S = map(int, read().split())
cows = deque(sorted(int(read()) for _ in range(N)))

ans = 0
while cows:
    low = cows.popleft()
    while cows and cows[-1] + low > S:
        cows.pop()
    ans+=len(cows)

print(ans)