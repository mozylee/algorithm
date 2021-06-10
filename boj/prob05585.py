# 출처: https://www.acmicpc.net/problem/5585
# 문제: 거스름돈

coins = [500, 100, 50, 10, 5, 1]

n = 1000 - int(input())
count = 0
i = 0

while n > 0:
    if coins[i] > n:
        i += 1
        continue
    count += n // coins[i]
    n %= coins[i]
print(count)

