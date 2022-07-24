import sys


read = sys.stdin.readline

ans = []
for _ in range(int(read())):
    a,b = input().split()
    ans.append("OK" if a==b else "ERROR")

print(*ans, sep="\n")