# 출처: https://www.acmicpc.net/problem/1398
# 문제: 동전문제


import sys

dp = [i for i in range(0, 100)]
coins = [10, 25]
for coin in coins:
    for i in range(coin, len(dp)):
        dp[i] = min(dp[i], dp[i - coin] + 1)

n = int(sys.stdin.readline())
for _ in range(n):
    car_price = int(sys.stdin.readline())
    coin_amount = 0

    while car_price:
        coin_amount += dp[car_price % 100]
        car_price //= 100
    print(coin_amount)
