# 출처: https://www.acmicpc.net/problem/11651
# 문제: 좌표 정렬하기2


import sys

coordinates = [
    tuple(map(int, sys.stdin.readline().split()))
    for _ in range(int(sys.stdin.readline()))
]
print(
    "\n".join(f"{x[0]} {x[1]}" for x in sorted(coordinates, key=lambda x: (x[1], x[0])))
)

