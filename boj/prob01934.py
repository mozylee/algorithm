# 출처: https://www.acmicpc.net/problem/1934
# 문제: 최소공배수


import sys
from math import gcd

for _ in range(int(input())):
    a, b = map(int, sys.stdin.readline().split())
    print(a * b // gcd(a, b))
