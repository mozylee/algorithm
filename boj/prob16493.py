import sys


read = sys.stdin.readline

N, M = map(int, read().split())
chapters = [(0, 0)] + [tuple(map(int, read().split())) for _ in range(M)]

dp = [[0]*(N+1) for _ in range(M+1)]

for m in range(1, M+1):
    for n in range(1, N+1):
        dp[m][n] = max(dp[m-1][n], 0 if n < chapters[m][0]
                       else (dp[m-1][n-chapters[m][0]] + chapters[m][1]))
print(dp[m][n])
