# Backjoon Online Judge: https://www.acmicpc.net/problem/10809
# 내용없음

import sys

s = sys.stdin.readline().rstrip()

for i in range(ord('a'), ord('z')):
    print(s.find(chr(i)), end=' ')
print(s.find('z'))
