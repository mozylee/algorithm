import sys

read = sys.stdin.readline

n, k = map(int, read().split())
memories = list(map(int, read().split()))
costs = list(map(int, read().split()))
sum_costs = sum(costs)
dp = [[0] * (sum_costs + 1) for _ in range(n + 1)]
ret = 1e11
for i in range(1, n + 1):
    memory, cost = memories[i - 1], costs[i - 1]
    for j in range(0, sum_costs + 1):
        if j >= cost:
            dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - cost] + memory)
        dp[i][j] = max(dp[i][j], dp[i - 1][j])
