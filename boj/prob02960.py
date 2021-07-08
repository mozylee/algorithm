# 출처: https://www.acmicpc.net/problem/2960
# 문제: 에라토스테네스의 체


n, k = map(int, input().split())

dp = [True] * (n + 1)
dp[0] = False
dp[1] = False

count = 0
for i in range(n + 1):
    if dp[i]:
        j = 1
        while i * j <= n:
            if dp[i * j]:
                count += 1
                if count == k:
                    print(i * j)
                    exit(0)
            dp[i * j] = False
            j += 1
