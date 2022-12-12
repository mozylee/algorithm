from collections import deque
import sys


read = sys.stdin.readline


N = int(read())
REMAINDER = 1_000_000_007

dp = deque([1, 1])
for i in range(3, N+1):
    dp.append((dp[0]+dp[1]) % REMAINDER)
    dp.popleft()

print(dp[-1], N-2)
