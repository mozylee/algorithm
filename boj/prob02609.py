# 출처: https://www.acmicpc.net/problem/2609
# 문제: 최대공약수와 최소공배수

import sys
from math import gcd

a, b = map(int, sys.stdin.readline().split())
print(gcd(a, b), a * b // gcd(a, b))
