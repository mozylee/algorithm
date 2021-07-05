# 출처: https://www.acmicpc.net/problem/1339
# 문제: 단어 수학


import sys
from collections import defaultdict

read = sys.stdin.readline
chars = defaultdict(int)

for _ in range(int(read())):
    for i, c in enumerate(read().rstrip()[::-1]):
        chars[c] += 10 ** i

c = 9
result = 0
for char in sorted(chars, key=lambda x: -chars[x]):
    result += chars[char] * c
    c -= 1
print(result)
