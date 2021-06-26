# 출처: https://www.acmicpc.net/problem/1436
# 문제: 영화감독 숌


import sys


read = sys.stdin.readline
n = int(read())
start = 666
while True:
    if "666" in str(start):
        n -= 1
        if n == 0:
            print(start)
            break
    start += 1100
