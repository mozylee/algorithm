import sys

read = sys.stdin.readline

n = int(read())

ans = []

for i in range(n):
    ans.append('*'*(i+1))

for i in range(n-1, 0, -1):
    ans.append('*'*(i))

print(*ans, sep="\n")