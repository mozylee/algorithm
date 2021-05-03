# 출처: https://www.acmicpc.net/problem/1918
# 문제: 후위 표기식


import sys

suffix_expression = ''
stack = list()
for char in sys.stdin.readline().rstrip():
    if char.isupper():
        suffix_expression += char
    elif char == '(':
        stack.append(char)
    elif char == ')':
        while stack and stack[-1] != '(':
            suffix_expression += stack.pop()
        stack.pop()
    else:
        if char in ('*', '/'):
            while stack and stack[-1] in ('*', '/'):
                suffix_expression += stack.pop()
        else:
            while stack and stack[-1] != '(':
                suffix_expression += stack.pop()
        stack.append(char)

if stack:
    suffix_expression += ''.join(stack[::-1])
print(suffix_expression)
