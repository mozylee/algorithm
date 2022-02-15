import sys


read = sys.stdin.readline

read()
A = set(map(int,read().split()))
B = set(map(int,read().split()))

C = A-B

print(len(C))
print(*sorted(C))
