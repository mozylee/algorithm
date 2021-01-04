# 출처: https://www.acmicpc.net/problem/15652
# 문제: N과 M 4
# pypy3


from itertools import product
import sys

read = sys.stdin.readline


def my_filter(sequence):
    for i, n in enumerate(sequence[:-1]):
        if n > sequence[i + 1]:
            return False
    return True


n, m = map(int, read().split())
sequences = list(filter(my_filter, product([i + 1 for i in range(n)], repeat=m)))
for sequence in sequences:
    print(*sequence)
