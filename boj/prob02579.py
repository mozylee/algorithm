# 출처: https://www.acmicpc.net/problem/2579
# 문제: 계단 오르기

import sys

read = sys.stdin.readline

stairs = [0]+[int(read()) for _ in range(int(read()))]

dp = [0]*len(stairs)
dp[1] = stairs[1]
if len(stairs) > 2:
    dp[2] = stairs[1]+stairs[2]

for i in range(3, len(stairs)):
    dp[i] += max(stairs[i - 1] + dp[i - 3], dp[i - 2]) + stairs[i]
print(dp.pop())
