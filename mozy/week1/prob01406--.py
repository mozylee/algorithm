# Backjoon Online Judge: https://www.acmicpc.net/problem/1406
# 문제: 에디터

# 시간 초과로 오답


import sys

#별짓 다해봤는데 입출력 시간 줄이는 것도 좋지만 걍 deque쓰는게 짱인듯
inputs = sys.stdin.readlines()
string = list(inputs[0])
args = list(map(str.split, inputs[2:]))
cursor = len(string)

for i in args:
    if i[0] == "L" and cursor > 0:
        cursor -= 1
    elif i[0] == "D" and cursor < len(string):
        cursor += 1
    elif i[0] == "B" and cursor > 0:
        cursor -= 1
        string.pop(cursor)
    elif i[0] == "P":
        string.insert(cursor, i[1])
        cursor += 1

sys.stdout.write(''.join(string))
