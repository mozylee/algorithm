# Backjoon Online Judge: https://www.acmicpc.net/problem/11721
# 내용없음

s = input()

for i in range(len(s) // 10 + 1):
    print(s[10 * i:10 * (i + 1)])
