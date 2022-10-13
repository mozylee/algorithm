import sys


read = sys.stdin.readline

N = int(read())
names = [read().rstrip() for _ in range(N)]
increasing = sorted(names)
decreasing = increasing[::-1]

flag1 = any(n!=i for n, i in zip(names, increasing))
flag2 = any(n!=d for n, d in zip(names, decreasing))

print("INCREASING" if flag1 else "DECREASING" if flag2 else "NEITHER")