from collections import Counter
import sys


is_okay = [1 if Counter(str(i)).most_common()[0][1] <= 1 else 0 for i in range(5002)]

ans= []
for line in sys.stdin.readlines():
    N, M = map(int, line.split())

    ans.append(sum(is_okay[N: M+1]))

print(*ans, sep = "\n")