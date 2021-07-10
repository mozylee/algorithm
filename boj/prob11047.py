# 출처: https://www.acmicpc.net/problem/11047
# 문제: 동전 0


import sys

read = sys.stdin.readline

n, k = map(int, read().split())
coins = [int(read()) for _ in range(n)]

result = 0
for coin in reversed(coins):
    if not k:
        break
    if k >= coin:
        result += k // coin
        k %= coin

print(result)
