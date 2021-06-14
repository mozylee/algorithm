# 출처: https://www.acmicpc.net/problem/1092
# 문제: 배

import sys

read = sys.stdin.readline
n = int(read())
cranes = sorted(map(int, read().split()), reverse=True)
m = int(read())
cargoes = sorted(map(int, read().split()), reverse=True)
if cargoes[0] > cranes[0]:
    print(-1)
    exit(0)
indexes = [0] * n
is_moved = [False] * m

done, time = 0, 0
while done < m:
    time += 1
    for i, crane in enumerate(cranes):
        while indexes[i] < m:
            if not is_moved[indexes[i]] and crane >= cargoes[indexes[i]]:
                done += 1
                is_moved[indexes[i]] = True
                break
            indexes[i] += 1
print(time)
