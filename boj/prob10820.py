# 출처: https://www.acmicpc.net/problem/10820
# 문제: 문자열 분석

import sys

for line in sys.stdin:
    result = [0] * 4
    for char in line:
        if char.islower():
            result[0] += 1
        elif char.isupper():
            result[1] += 1
        elif char.isnumeric():
            result[2] += 1
        elif char == ' ':
            result[3] += 1
    print(' '.join(str(i) for i in result))
