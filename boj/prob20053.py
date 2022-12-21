import sys


read = sys.stdin.readline

ans = []
for _ in range(int(read())):
    read()
    min_value, max_value = 1e9, -1e9

    for n in map(int,read().split()):
        min_value=min(min_value, n)
        max_value=max(max_value, n)
    
    ans.append(f"{min_value} {max_value}")

print(*ans, sep="\n")