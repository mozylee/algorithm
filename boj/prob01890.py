import sys

read = sys.stdin.readline

N = int(read())

jumps = [list(map(int, read().split())) for _ in range(N)]

dp = [[0]*N for _ in range(N)]
dp[0][0] = 1

for i, line in enumerate(jumps):
    for j, jump in enumerate(line):
        if jump == 0:
            continue

        if i+jump < N:
            dp[i+jump][j] += dp[i][j]

        if j+jump < N:
            dp[i][j+jump] += dp[i][j]

print(dp[-1][-1])
