from math import ceil
import sys


read = sys.stdin.readline

counts = [0]*10

for c in map(int, list(read().rstrip())):
    counts[c] += 1

counts[6] = ceil((counts[6]+counts[9])/2)
counts[9] = counts[6]

print(max(counts))