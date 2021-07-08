# 출처: https://www.acmicpc.net/problem/15664
# 문제: N과 M 10


def my_filter(a):
    last = a[0]
    for el in a[1:]:
        if el < last:
            return False
        last = el
    return True


from itertools import permutations
import sys

read = sys.stdin.readline

n, m = map(int, read().split())
sequences = set(filter(my_filter, permutations(map(int, read().split()), m)))
for sequence in sorted(sequences):
    print(*sequence)
