from collections import defaultdict
import sys


read = sys.stdin.readline
scores = sorted((tuple(map(int, read().split()))
                for _ in range(int(read()))), key=lambda x: -x[2])

countries = defaultdict(int)
ans = []
index = 0
while len(ans) < 3:
    student = scores[index]
    index += 1
    if countries[student[0]] > 1:
        continue
    countries[student[0]] += 1
    ans.append(f"{student[0]} {student[1]}")

print(*ans, sep="\n")
