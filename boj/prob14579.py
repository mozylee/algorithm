import sys


read = sys.stdin.readline
REMAINDER = 14579

a, b = map(int, read().split())

ans = 1
for i in range(a, b+1):
    ans *= (i+1)*i//2
    ans %= REMAINDER

print(ans)
