# 출처: https://www.acmicpc.net/problem/11650
# 문제: 좌표 정렬하기


import sys
read = sys.stdin.readline
coordinates = [tuple(map(int, read().split())) for _ in range(int(read()))]

print(*[f'{x[0]} {x[1]}' for x in sorted(coordinates, key=lambda x: x)], sep="\n")
