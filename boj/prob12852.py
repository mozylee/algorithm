# 출처: https://www.acmicpc.net/problem/12852
# 문제: 1로 만들기 2


n = int(input())
dp = {i: [0, [i]] for i in range(1, 10 ** 6 + 1)}
dp[1][0] = 0
dp[2][0] = 1
dp[2][1] += dp[1][1]

for i in range(3, n + 1):
    comparisons = [i - 1]
    if i % 2 == 0:
        comparisons.append(i // 2)
    if i % 3 == 0:
        comparisons.append(i // 3)
    min_comparison = min(comparisons, key=lambda x: dp[x][0])
    dp[i][0] = dp[min_comparison][0] + 1
    dp[i][1] += dp[min_comparison][1]

print(dp[n][0])
print(' '.join(str(i) for i in dp[n][1]))
