import sys


read = sys.stdin.readline

resorts = [tuple(map(int, read().split())) for _ in range(int(read()))]
nears = sorted(resorts, key=lambda x: x[0])
prices = sorted(resorts, key=lambda x: x[1])

ans = 0
for r in resorts:
    flag = True
    for n in nears:
        if n[0] > r[0]:
            break

        if n[1] < r[1]:
            flag = False
            break
    
    if not flag:
        continue

    for p in prices:
        if p[1] > r[1]:
            break

        if p[0] < r[0]:
            flag = False
            break
    
    ans += 1 if flag else 0

print(ans)
