# 출처: https://www.acmicpc.net/problem/11505
# 문제: 구간 곱 구하기


import sys
from math import log2

read = sys.stdin.readline

n, m, k = map(int, read().split())
SIZE = 2**int(log2(n)+1)-1
MOD = 1000000007
tree = [1]*SIZE*2


def update(i, n):
    i += SIZE
    tree[i] = n
    p = i//2
    while p > 1:
        tree[p] = (tree[p*2]*tree[p*2+1]) % MOD
        p //= 2


def get_mul(i, j):
    i += SIZE
    j += SIZE

    ret = 1
    while i <= j:
        if i % 2:
            ret = (ret*tree[i]) % MOD
            i += 1
        if not j % 2:
            ret = (ret*tree[j]) % MOD
            j -= 1
        i //= 2
        j //= 2
    return ret


for i in range(n):
    update(i, int(read()))
for _ in range(m + k):
    a, b, c = map(int, read().split())
    if a == 1:
        update(b-1, c)
    else:
        print(get_mul(b-1, c-1))
