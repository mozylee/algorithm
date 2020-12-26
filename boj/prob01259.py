# 출처: https://www.acmicpc.net/problem/1259
# 문제: 팰린드롬수

import sys


def is_palindrome(s):
    for i in range(len(n) // 2):
        if n[i] != n[-(i + 1)]:
            return False
    return True


while True:
    n = sys.stdin.readline().rstrip()
    if n == '0':
        break

    print('yes' if is_palindrome(n) else 'no')
