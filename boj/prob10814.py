# 출처: https://www.acmicpc.net/problem/10814
# 문제: 나이순 정렬

import sys

members = []
n = int(sys.stdin.readline())
for i in range(n):
    age, name = sys.stdin.readline().rstrip().split()
    members.append((int(age), i, name))

print('\n'.join([f'{x[0]} {x[2]}' for x in sorted(members, key=lambda x: (x[0], x[1]))]))
