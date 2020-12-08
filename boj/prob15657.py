# 출처: https://www.acmicpc.net/problem/15657
# 문제: N과 M 8


from itertools import combinations_with_replacement
import sys

read = sys.stdin.readline

n, m = map(int, read().split())
sequences = combinations_with_replacement(sorted(set(map(int, read().split()))), m)
for sequence in sequences:
    print(*sequence)
