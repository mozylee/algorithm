import sys


read = sys.stdin.readline

ans = []
for _ in range(int(read())):
    W,K = map(int,read().split())
    ans.append((W*K)//2)

print(*ans, sep="\n")