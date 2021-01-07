# 출처: https://www.acmicpc.net/problem/17219
# 문제: 비밀번호 찾기

from sys import stdin

n, m = map(int, stdin.readline().split())
notepad = dict()
for _ in range(n):
    id, pw = stdin.readline().rstrip().split()
    notepad[id] = pw

for _ in range(m):
    print(notepad[stdin.readline().rstrip()])
