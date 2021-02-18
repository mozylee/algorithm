# 출처: https://www.acmicpc.net/problem/11050
# 문제: 이항계수 1


import sys
from math import factorial

n, k = map(int, sys.stdin.readline().split())
print(factorial(n) // factorial(k) // factorial(n - k))
