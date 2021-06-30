# 출처: https://www.acmicpc.net/problem/17224
# 문제: APC는 왜 서브태스크 대회가 되었을까?


import sys

read = sys.stdin.readline

n, l, k = map(int, read().split())
hard, easy = 0, 0
result = 0
for _ in range(n):
    e, d = map(int, read().split())
    if l >= d:
        hard += 1
    elif l >= e:
        easy += 1
    if e > l:
        break


result += min(k, hard) * 140
if k > hard:
    result += min(k - hard, easy) * 100
print(result)
