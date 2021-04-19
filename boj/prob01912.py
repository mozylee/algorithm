# 출처: https://www.acmicpc.net/problem/1912
# 문제: 연속합


import sys

read = sys.stdin.readline
_ = read()
num = list(map(int, read().split()))
dp = [num[0]]

for i in range(1, len(num)):
    dp.append(max(num[i], dp[i - 1] + num[i]))
print(max(dp))

