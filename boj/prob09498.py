# Backjoon Online Judge: https://www.acmicpc.net/problem/9498
# 내용없음

import sys

score = int(sys.stdin.readline()) // 10 - 5
grade = ['F', 'D', 'C', 'B', 'A', 'A']

print(grade[score if score > -1 else 0])
