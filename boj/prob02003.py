# 출처: https://www.acmicpc.net/problem/2003
# 문제: 수들의 합 2


import sys

read = sys.stdin.readline
n, m = map(int, read().split())
arr = list(map(int, read().split()))
s, e = 0, 0
count = 0
while s < n and e < n:
    sum_subarr = sum(arr[s : e + 1])
    print(arr[s : e + 1])

    if sum_subarr == m:
        count += 1

    if sum_subarr >= m:
        s += 1
    elif sum_subarr < m:
        e += 1
print(count)

