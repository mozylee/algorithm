import sys


read=sys.stdin.readline

n = int(read())

ans = 1
for b in map(int, read().split()):
    ans *= b

print(ans)