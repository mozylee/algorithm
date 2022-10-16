import sys


read = sys.stdin.readline

ans = []
for _ in range(int(read())):
    n = int(read())
    scores = list(map(int, read().split()))

    total = sum(scores)
    avg = total/n
    
    ans.append(f"{sum(1 if s>=avg else 0 for s in scores)}/{n}")

print(*ans, sep="\n")