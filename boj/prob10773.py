# 출처: https://www.acmicpc.net/problem/10773
# 문제: 제로


import sys

read = sys.stdin.readline
stack = []

for _ in range(int(read())):
    num = int(read())
    if num == 0:
        stack.pop()
    else:
        stack.append(num)
print(sum(stack))
