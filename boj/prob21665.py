import sys


read = sys.stdin.readline
N, M = map(int, input().split())

main = [read().rstrip() for _ in range(N)]
read()
reversal = [read().rstrip() for _ in range(N)]

count = 0
for line1, line2 in zip(main, reversal):
    for c1, c2 in zip(line1, line2):
        count += 1 if c1 == c2 else 0

print(count)