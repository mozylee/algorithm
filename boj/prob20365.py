import sys

read = sys.stdin.readline


def compress(line: str) -> str:
    compressed = line[0]
    counts = {'B':0, 'R':0}
    counts[compressed] += 1
    for c in line[1:]:
        if compressed[-1] == c:
            continue
        compressed += c
        counts[c] += 1
    return counts


read()
counts = compress(read().rstrip())

print(min(counts.values())+1)
