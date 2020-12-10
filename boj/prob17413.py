# 출처: https://www.acmicpc.net/problem/17413
# 문제: 단어 뒤집기2


import sys

start = 0
isLessThanSign = False
string = sys.stdin.readline().rstrip()
result = ''

for i, char in enumerate(string):
    if isLessThanSign:
        result += char
        if char == '>':
            isLessThanSign = False
            start = i + 1
    elif char == ' ':
        result += (' ' if result and result[-1] != '>' else '') + string[start:i][::-1]
        start = i + 1
    elif char == '<':
        isLessThanSign = True
        if i != start:
            result += (' ' if result and result[-1] != '>' else '') + string[start:i][::-1]
        result += char
if start < len(string) - 1:
    result += (' ' if result and result[-1] != '>' else '') + string[start:][::-1]
print(result)
