# 출처: https://www.acmicpc.net/problem/15666
# 문제: N과 M 12


from itertools import combinations_with_replacement
import sys

read = sys.stdin.readline

n, m = map(int, read().split())
sequences = set(combinations_with_replacement(sorted(map(int, read().split())), m))
for sequence in sorted(sequences):
    print(*sequence)
