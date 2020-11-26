# 출처: https://www.acmicpc.net/problem/10808
# 문제: 알파벳 개수

import sys

s = sys.stdin.readline().rstrip()
alphabet = [0] * 26

for char in s:
    alphabet[ord(char) - ord('a')] += 1

print(' '.join(str(char) for char in alphabet))
