# 출처: https://www.acmicpc.net/problem/3425
# 문제: 고스택


def div(a, b):
    _a, _b = abs(a), abs(b)
    result = _a // _b
    return result if a * b >= 0 else -result


def mod(a, b):
    _a, _b = abs(a), abs(b)
    result = _a % _b
    return result if a >= 0 else -result


import sys
from collections import deque

read = sys.stdin.readline

stack = []
commands = deque()

answer = []
while True:
    c = read().rstrip()
    if c == "QUIT":
        break
    elif c == "END":
        pass
    else:
        commands.append(c)
        continue

    for _ in range(int(read())):
        n = read()
        if n == "\n":
            break
        stack.append(int(n))
        is_breaked = False

        for c in commands:
            if c.startswith("NUM"):
                x = int(c.split()[-1])
                stack.append(x)
            elif c.startswith("POP"):
                if not stack:
                    is_breaked = True
                    break
                stack.pop()
            elif c.startswith("INV"):
                if not stack:
                    is_breaked = True
                    break
                stack.append(-stack.pop())
            elif c.startswith("DUP"):
                if not stack:
                    is_breaked = True
                    break
                stack.append(stack[-1])
            elif c.startswith("SWP"):
                if len(stack) < 2:
                    is_breaked = True
                    break
                a, b = stack.pop(), stack.pop()
                stack.append(a)
                stack.append(b)
            elif c.startswith("ADD"):
                if len(stack) < 2:
                    is_breaked = True
                    break
                a, b = stack.pop(), stack.pop()
                if not (0 <= abs(a + b) <= 10 ** 9):
                    is_breaked = True
                    break
                stack.append(a + b)
            elif c.startswith("SUB"):
                if len(stack) < 2:
                    is_breaked = True
                    break
                op1 = stack.pop()
                op2 = stack.pop()
                if not (0 <= abs(op2 - op1) <= 10 ** 9):
                    is_breaked = True
                    break
                stack.append(op2 - op1)
            elif c.startswith("MUL"):
                if len(stack) < 2:
                    is_breaked = True
                    break
                a, b = stack.pop(), stack.pop()
                if not (0 <= abs(a * b) <= 10 ** 9):
                    is_breaked = True
                    break
                stack.append(a * b)
            elif c.startswith("DIV"):
                if len(stack) < 2:
                    is_breaked = True
                    break
                op1 = stack.pop()
                op2 = stack.pop()
                if op1 == 0:
                    is_breaked = True
                    break
                stack.append(div(op2, op1))
            elif c.startswith("MOD"):
                if len(stack) < 2:
                    is_breaked = True
                    break
                op1 = stack.pop()
                op2 = stack.pop()
                if op1 == 0:
                    is_breaked = True
                    break
                stack.append(mod(op2, op1))

        if not is_breaked:
            if len(stack) != 1:
                answer.append("ERROR")
            else:
                answer.append(stack[-1])
        else:
            answer.append("ERROR")
        stack = []
    commands = []
    answer.append("")


print(*answer, sep="\n")
