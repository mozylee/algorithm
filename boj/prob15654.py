# 출처: https://www.acmicpc.net/problem/15654
# 문제: N과 M 5


from itertools import permutations
import sys

read = sys.stdin.readline

n, m = map(int, read().split())
sequences = permutations(sorted(set(map(int, read().split()))), m)
for sequence in sequences:
    print(*sequence)
