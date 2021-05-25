# 출처: https://www.acmicpc.net/problem/1495
# 문제: 기타리스트


import sys

read = sys.stdin.readline
n, s, m = map(int, read().split())
v = list(map(int, read().split()))
dp = [[False] * (m + 1) for _ in range(n + 1)]
dp[0][s] = True

for i in range(0, n):
    for j in range(0, m + 1):
        if dp[i][j]:
            vol = v[i]
            if j + vol <= m:
                dp[i + 1][j + vol] = True
            if j - vol > -1:
                dp[i + 1][j - vol] = True
    if True not in dp[i + 1]:
        print(-1)
        exit(0)

for i in range(m, -1, -1):
    if dp[-1][i]:
        print(i)
        break
