# 출처: https://www.acmicpc.net/problem/15649
# 문제: N과 M 1


from itertools import permutations
import sys

read = sys.stdin.readline

n, m = map(int, read().split())
sequences = permutations([i + 1 for i in range(n)], m)
for sequence in sequences:
    print(*sequence)
