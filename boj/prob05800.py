import sys


read = sys.stdin.readline

ans = []
for i in range(int(read())):
    scores = sorted(list(map(int, read().split()))[1:])
    max_score, min_score = scores[-1], scores[0]
    gap = 0
    for j in range(len(scores[:-1])):
        gap = max(gap, abs(scores[j]-scores[j+1]))

    ans.append(
        f"Class {i+1}\nMax {max_score}, Min {min_score}, Largest gap {gap}")

print(*ans, sep="\n")
