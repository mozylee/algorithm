# 출처: https://www.acmicpc.net/problem/2042
# 문제: 구간 합 구하기


import sys

read = sys.stdin.readline

n, m, k = map(int, read().split())
SIZE = 2**20
tree = [0]*SIZE*2

# index tree
def update(i, n):
    i += SIZE
    tree[i] = n
    p = i//2
    while p > 1:
        tree[p] = tree[p*2]+tree[p*2+1]
        p //= 2


def get_sum(i, j):
    i += SIZE
    j += SIZE

    ret = 0
    while i <= j:
        if i % 2:
            ret += tree[i]
            i += 1
        if not j % 2:
            ret += tree[j]
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
        print(get_sum(b-1, c-1))
