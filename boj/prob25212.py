from itertools import combinations
import sys

read = sys.stdin.readline

N = int(read())
cakes = [1/int(x)  for x in map(int, read().split())]

ans = 0
for i in range(1, len(cakes)+1):
    for c in combinations(cakes, i):
        ans += 1 if 0.99<=sum(c)<=1.01 else 0

print(ans)