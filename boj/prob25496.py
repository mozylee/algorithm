import sys


read = sys.stdin.readline

P, N = map(int, read().split())

count = 0
for a in sorted(map(int, read().split())):
    if P >= 200:
        break

    P += a
    count += 1

print(count)
