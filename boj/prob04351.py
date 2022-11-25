import sys


read = sys.stdin.readline


m, n = map(int, read().split())

words = {}
for _ in range(m):
    word, cost = read().rstrip().split()

    words[word]=int(cost)


ans = []
hay_point = 0
while True:
    if len(ans) == n:
        break

    line = read().rstrip()

    if line == '.':
        ans.append(hay_point)
        hay_point = 0
        continue
    
    for c in line.split():
        hay_point += words[c] if c in words else 0

print(*ans, sep="\n")