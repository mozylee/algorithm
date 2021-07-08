# 출처: https://www.acmicpc.net/problem/11051
# 문제: 이항계수 2


import sys
from math import factorial

n, k = map(int, sys.stdin.readline().split())
print(factorial(n) // factorial(k) // factorial(n - k) % 10007)

