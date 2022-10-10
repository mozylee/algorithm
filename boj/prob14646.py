import sys


read = sys.stdin.readline

N = int(read())

stickers = [0]*(N+1)
remains = 0
max_remains = 0
for s in map(int, read().split()):
    if stickers[s] == 0:
        remains += 1
        max_remains = max(remains, max_remains)
        stickers[s] += 1
        continue

    remains -= 1

print(max_remains)
