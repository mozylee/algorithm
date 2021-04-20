# 출처: https://www.acmicpc.net/problem/7490
# 문제: 0 만들기


import sys
from itertools import product

read = sys.stdin.readline
operator = [' ', '+', '-']
for _ in range(int(read())):
    n = int(read())
    for ops in product(operator, repeat=n - 1):
        expression = ''
        for i, op in enumerate(ops):
            expression += str(i + 1) + op
        expression += str(n)

        if eval(expression.replace(' ', '')) == 0:
            print(expression)
    print()
