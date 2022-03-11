from collections import defaultdict
import sys


read = sys.stdin.readline
while True:
    counts = defaultdict(int)
    line = read().rstrip().lower()

    if line == "#":
        break

    for c in line:
        counts[c] += 1

    print(counts['a'] + counts['e'] + counts['i'] + counts['o'] + counts['u'])
