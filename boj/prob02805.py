# 출처: https://www.acmicpc.net/problem/2805
# 문제: 나무 자르기


import sys

read = sys.stdin.readline

n, m = map(int, read().split())
trees = tuple(map(int, read().split()))

s, e = 1, max(trees)

while s <= e:
    mid = (s + e) // 2
    cut = sum(t - mid for t in trees if t > mid)
    if cut >= m:
        s = mid + 1
    else:
        e = mid - 1

print(e)
