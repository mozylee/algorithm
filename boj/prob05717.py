import sys


read = sys.stdin.readline

M, F = map(int, read().split())

ans = []
while M != 0 and F != 0:
    ans.append(M+F)

    M, F = map(int, read().split())

print(*ans, sep="\n")
