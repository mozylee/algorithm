# Backjoon Online Judge: https://www.acmicpc.net/problem/1076
# 내용없음

import sys

res = []
for i in range(3):
    res.append(sys.stdin.readline().rstrip())
colors = ['black', 'brown', 'red', 'orange', 'yellow', 'green', 'blue', 'violet', 'grey', 'white']
resistance = {color: (i, 10 ** (i)) for i, color in enumerate(colors)}
print((resistance[res[0]][0] * 10 + resistance[res[1]][0]) * resistance[res[2]][1])
