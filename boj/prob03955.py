# 출처: https://www.acmicpc.net/problem/3955
# 문제: 캔디 분배


import sys

MESSAGE = 'IMPOSSIBLE'


def get_euclid(a, b, K):
    s0, s1, t0, t1 = 1, 0, 0, 1
    while b != 0:
        q = a//b
        r = a % b
        a, b = b, r
        s = s0-q*s1
        t = t0-q*t1
        s0, s1 = s1, s
        t0, t1 = t1, t
    t0 = (t0 % K + K) % K
    if a != 1 or t0 > 10**9:
        return MESSAGE
    return t0


read = sys.stdin.readline

for _ in range(int(read())):
    K, C = map(int, read().split())
    if C == 1:
        if K+1 > 10**9:
            print(MESSAGE)
        else:
            print(K+1)
        continue
    if K == 1:
        print(1)
        continue
    print(get_euclid(K, C, K))
