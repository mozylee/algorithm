# 출처: https://www.acmicpc.net/problem/1179
# 문제: 마지막 요세푸스 문제
# 참고: https://johngrib.github.io/wiki/c-m-01-Recurrent-Problems-03/


import sys
import math

n, k = map(int, sys.stdin.readline().split())
m = int(math.log(n, k))
l = n % (k ** m)

print(m, l)
print(2 * l + 1)
