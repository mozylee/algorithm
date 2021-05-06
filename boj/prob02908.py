# Backjoon Online Judge: https://www.acmicpc.net/problem/2908
# 내용없음

import sys

print(max([int(num[-1::-1]) for num in sys.stdin.readline().rstrip().split()]))
