# 출처: https://www.acmicpc.net/problem/11650
# 문제: 좌표 정렬하기


import sys

n = int(sys.stdin.readline())
coordinates = list()
for _ in range(n):
    coordinates.append(tuple(map(int, sys.stdin.readline().split())))

print('\n'.join([f'{x[0]} {x[1]}' for x in sorted(coordinates, key=lambda x: x)]))
