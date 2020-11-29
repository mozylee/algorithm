# 출처: https://www.acmicpc.net/problem/4153
# 문제: 직각삼각형


import sys

while True:
    a, b, c = sorted(map(int, sys.stdin.readline().split()))
    if a + b + c == 0:
        break
    print('right' if c ** 2 == a ** 2 + b ** 2 else 'wrong')
