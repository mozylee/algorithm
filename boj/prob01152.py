# Backjoon Online Judge: https://www.acmicpc.net/problem/1152
# ' ', ''와 같이 공백 한개, 빈 문자열에 대한 예외처리 필요.
# 필자는 strip()을 통해서 공백만 입력 받은 경우를 처리, 빈 문자열은 if else문을 통해 처리

import sys

s = sys.stdin.readline().strip()
print(s.count(' ') + 1 if len(s) > 0 else 0)
