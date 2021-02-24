# 출처: https://www.acmicpc.net/problem/2693
# 문제: N번째 큰 수


import sys

read = sys.stdin.readline

for _ in range(int(read())):
    print(sorted(map(int, read().split()))[-3])
