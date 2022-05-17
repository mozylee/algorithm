from collections import defaultdict
import sys


read = sys.stdin.readline


N = int(read())
nums = [read().rstrip()[::-1] for _ in range(N)]
decimal = {chr(ord('A')+i): -1 for i in range(10)}

weights = defaultdict(int)
for num in nums:
    for i, c in enumerate(num):
        weights[c] += 10**i

firsts = set(n[-1] for n in nums)

keys = sorted(decimal.keys(), key=lambda x: -weights[x])
for n in sorted(decimal.keys(), key=lambda x: weights[x]):
    if n not in firsts:
        decimal[n] = 0
        keys.remove(n)
        break

ret = 0
for v, key in zip(range(9, 0, -1), keys):
    ret += v*weights[key]
print(ret)
