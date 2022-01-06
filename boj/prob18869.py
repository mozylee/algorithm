import sys
from collections import Counter

read = sys.stdin.readline

M, N = map(int, read().split())

spaces =[list(map(int, read().split()))for _ in range(M)]

compressed = []
for s in spaces:
    space_dict = {v:str(i).zfill(4) for i, v in enumerate(sorted(set(s)))}
    compressed.append("".join(space_dict[space] for space in s))
    
print(sum(v*(v-1)//2 for v in Counter(compressed).values()))