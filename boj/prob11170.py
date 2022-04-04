from collections import defaultdict
import sys


read = sys.stdin.readline

memo = {}
answer = []
for _ in range(int(read())):
    counts = defaultdict(int)
    N, M = map(int, read().split())
    for i in range(N, M+1):
        if i in memo.keys():
            counts['0'] += memo[i]
            continue
        m = 0
        for c in str(i):
            counts[c] += 1
            m += 1 if c == '0' else 0
        memo[i] = m
    answer.append(counts['0'])

print(*answer, sep="\n")
