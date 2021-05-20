# 출처: https://www.acmicpc.net/problem/1236
# 문제: 성 지키기


import sys

read = sys.stdin.readline
n, m = map(int, read().split())
rows, columns = set(i for i in range(n)), set(i for i in range(m))
for i in range(n):
    for j, ch in enumerate(read().rstrip()):
        if ch == 'X':
            if i in rows:
                rows.remove(i)
            if j in columns:
                columns.remove(j)
print(max(len(rows), len(columns)))
