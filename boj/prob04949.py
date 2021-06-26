# 출처: https://www.acmicpc.net/problem/4949
# 문제: 균형잡힌 세상


import sys

read = sys.stdin.readline

pair = {")": "(", "]": "["}

while True:
    line = read().rstrip()
    if line == ".":
        break
    stack = list()
    is_balanced = True
    for char in line:
        if char in ("(", "["):
            stack.append(char)

        elif char in (")", "]"):
            if not stack:
                is_balanced = False
                break
            last = stack.pop()
            if last != pair[char]:
                is_balanced = False
                break
    if stack:
        is_balanced = False

    print("yes" if is_balanced else "no")

