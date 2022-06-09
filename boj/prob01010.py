from collections import defaultdict
from math import comb
import sys


read = sys.stdin.readline

memory = defaultdict(str)
ans = []
for i in range(int(read())):
    N, M = map(int, read().split())
    N, M = max(N, M), min(N, M)
    if memory[(N, M)] == "":
        memory[(N, M)] = str(comb(N, M))
    ans.append(memory[(N, M)])

print("\n".join(ans))
