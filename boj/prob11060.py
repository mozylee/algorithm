import sys

read = sys.stdin.readline

N = int(read())

jumps = list(map(int, read().split()))

dp = [0]+[1e9]*N
for i, jump in enumerate(jumps):
    for j in range(1, jump+1):
        if i+j >= N:
            break
        dp[i+j] = min(dp[i+j], dp[i]+1)

print(dp[N-1] if dp[N-1] < 1e9 else -1)
