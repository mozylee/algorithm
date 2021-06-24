# 출처: https://www.acmicpc.net/problem/7568
# 문제: 덩치


import sys

read = sys.stdin.readline

n = int(read())
people = [tuple(map(int, read().split())) for _ in range(n)]
rankings = []
for i in range(n):
    ranking = 1
    for j in range(n):
        if people[i][0] < people[j][0] and people[i][1] < people[j][1]:
            ranking += 1
    rankings.append(str(ranking))

print("\n".join(rankings))
