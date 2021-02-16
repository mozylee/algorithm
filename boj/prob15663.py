# 출처: https://www.acmicpc.net/problem/15663
# 문제: N과 M 9


from itertools import permutations
import sys

read = sys.stdin.readline

n, m = map(int, read().split())
sequences = set(permutations(map(int, read().split()), m))
for sequence in sorted(sequences):
    print(*sequence)
