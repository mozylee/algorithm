import sys


read = sys.stdin.readline

ans = []
while (N := int(read())) > 0:
    guys = [tuple(read().rstrip().split()) for _ in range(N)]
    max_height = max(float(h) for g, h in guys)
    ans.append(" ".join(g for g, h in guys if float(h) == max_height))

print(*ans, sep="\n")
