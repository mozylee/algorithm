# 출처: https://www.acmicpc.net/problem/10250
# 문제: ACM 호텔


import sys

n = int(sys.stdin.readline())

for i in range(n):
    h, w, n = map(int, sys.stdin.readline().split())
    floor = (n - 1) % h + 1
    room_number = (n - 1) // h + 1
    print(str(floor) + str(room_number).zfill(2))
