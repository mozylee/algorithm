from math import ceil
import sys


read = sys.stdin.readline

ans = []
for _ in range(int(read())):
    N, C = map(int, read().split())
    ans.append(ceil(N/C))

print(*ans, sep="\n")