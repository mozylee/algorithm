import sys

read = sys.stdin.readline

N, S, R = map(int, read().split())

teams = [1] * (N+2)


for damage in map(int, read().split()):
    teams[damage] -= 1

for spare in map(int, read().split()):
    teams[spare] += 1


ans = 0
for i in range(1, N+1):
    if teams[i] > 0:
        continue

    if teams[i-1] > 1:
        teams[i-1] -= 1
        teams[i] += 1
        continue

    if teams[i+1] > 1:
        teams[i+1] -= 1
        teams[i] += 1
        continue

    ans += 1

print(ans)
