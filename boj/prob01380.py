import sys


read = sys.stdin.readline

ans = []
count = 1
while (N := int(read())) > 0:
    names = {i+1: read().rstrip() for i in range(N)}
    counts = {i+1: 0 for i in range(N)}

    for _ in range(N*2-1):
        n, _ = read().split()
        counts[int(n)] += 1

    ans.append(f"{count} {names[min(counts.keys(), key=lambda x: counts[x])]}")
    count += 1

print(*ans, sep="\n")
