import sys
from collections import defaultdict
from bisect import bisect_right, bisect_left


def read(): return sys.stdin.readline()


fibo = [1, 2] + [0]*1001

for i in range(2, len(fibo)):
    fibo[i] = fibo[i-1] + fibo[i-2]

answer = []
while True:
    a, b = map(int, read().split())

    if a == 0 and b == 0:
        break

    answer.append(bisect_right(fibo, b) - bisect_left(fibo, a))

print("\n".join(map(str, answer)))
