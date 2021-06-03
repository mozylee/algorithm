# 출처: https://www.acmicpc.net/problem/3460
# 문제: 이진수


import sys
read = sys.stdin.readline

for _ in range(int(read())):
    binary = bin(int(read()))[2:]
    print(' '.join(str(i) for i, digit in enumerate(reversed(binary)) if digit == '1'))