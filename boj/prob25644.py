import sys


read = sys.stdin.readline

min_stock = 1e9
max_price = 0

read()

for s in map(int, read().split()):
    min_stock = min(min_stock, s)

    max_price = max(max_price, s - min_stock)

print(max_price)