# 출처: https://www.acmicpc.net/problem/2166
# 문제: 다각형의 면적


import sys

read = sys.stdin.readline
n = int(read())
x, y = [], []
for _ in range(n):
    xi, yi = map(int, read().split())
    x.append(xi)
    y.append(yi)

x.append(x[0])
y.append(y[0])
result = 0

for i in range(n):
    result += x[i]*y[i+1] - x[i+1]*y[i]
print(round(abs(result)/2, 1))
