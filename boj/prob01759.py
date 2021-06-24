# 출처: https://www.acmicpc.net/problem/1759
# 문제: 암호 만들기

from itertools import combinations
import sys

read = sys.stdin.readline


def is_ok(string):
    count_vowel = 0
    for char in string:
        if char in ("a", "e", "i", "o", "u"):
            count_vowel += 1
    return count_vowel >= 1 and len(string) - count_vowel >= 2


L, C = map(int, input().split())
for string in combinations(sorted(read().rstrip().split()), L):
    if is_ok(string):
        print("".join(string))
