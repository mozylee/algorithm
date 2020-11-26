# 출처: https://www.acmicpc.net/problem/9095
# 문제: 1, 2, 3 더하기

dp = [0, 1, 2, 4]

for i in range(4, 11):
    dp.append(sum(dp[i - j] for j in (1, 2, 3)))

for _ in range(int(input())):
    print(dp[int(input())])
