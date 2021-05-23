# 출처: https://www.acmicpc.net/problem/1003
# 문제: 피보나치 함수

from sys import stdin

nums = [int(stdin.readline()) for _ in range(int(stdin.readline()))]
dp = [[0, 0] for _ in range(40 + 1)]
dp[0] = [1, 0]
dp[1] = [0, 1]

for i in range(2, max(nums) + 1):
    dp[i] = [dp[i - 1][0] + dp[i - 2][0], dp[i - 1][1] + dp[i - 2][1]]

print('\n'.join(f'{dp[x][0]} {dp[x][1]}' for x in nums))
