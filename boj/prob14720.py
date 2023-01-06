import sys

read = sys.stdin.readline

MILKS = [0, 1, 2]

read()

count = 0
for store in map(int, read().split()):
    if store != MILKS[count % 3]:
        continue

    count += 1

print(count)