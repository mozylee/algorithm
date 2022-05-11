import sys


read = sys.stdin.readline

ans = ""
for i in range(int(read())):
    n, s, d = map(int, read().split())
    distance, weights = s*d, 0
    for _ in range(n):
        di, vi = map(int, read().split())
        weights += vi if di <= distance else 0
    ans+= f'Data Set {i+1}:\n{weights}\n\n'

print(ans[:-2],end="")
