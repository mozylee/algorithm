# 출처: https://www.acmicpc.net/problem/15650
# 문제: N과 M 2


from itertools import combinations


n, m = map(int, input().split())
sequences = list(combinations([i + 1 for i in range(n)], m))
for sequence in sequences:
    print(*sequence)
