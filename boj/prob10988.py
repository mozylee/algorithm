# 출처: https://www.acmicpc.net/problem/10988
# 문제: 팰린드롬인지 확인하기


import sys

word = sys.stdin.readline().rstrip()
print(1 if word == word[::-1] else 0)
