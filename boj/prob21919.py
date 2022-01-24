from math import gcd
import sys


read = sys.stdin.readline
MAX = 1_000_000
era = [True]*(MAX+1)


def set_primes():
    for i in range(2, int(MAX**0.5)+1):
        if era[i]:
            for j in range(i+i, MAX, i):
                era[j] = False


def is_prime(n):
    return era[n]

set_primes()
n = int(read())
A = list(filter(lambda x: is_prime(x), map(int, read().split())))
if not A:
    print(-1)
    exit(0)
ret = 1
for a in A:
    GCD = gcd(ret, a)
    ret *= a
    ret //= GCD
print(ret)
