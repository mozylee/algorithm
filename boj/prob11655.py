# 출처: https://www.acmicpc.net/problem/11655
# 문제: ROT13

import sys

plain_text = sys.stdin.readline().rstrip()
cipher_text = ''

for char in plain_text:
    if char.isalpha():
        if char.isupper():
            char = chr((ord(char) - ord('A') + 13) % 26 + ord('A'))
        else:
            char = chr((ord(char) - ord('a') + 13) % 26 + ord('a'))
    cipher_text += char

print(cipher_text)
