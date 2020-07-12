# Backjoon Online Judge: https://www.acmicpc.net/problem/1406
# 문제: 에디터

# 한 줄로 된 간단한 에디터를 구현하려고 한다. 이 편집기는 영어 소문자만을 기록할 수 있는 편집기로, 최대 600,000글자까지 입력할 수 있다.
# 이 편집기에는 '커서'라는 것이 있는데, 커서는 문장의 맨 앞(첫 번째 문자의 왼쪽), 문장의 맨 뒤(마지막 문자의 오른쪽)
# 또는 문장 중간 임의의 곳(모든 연속된 두 문자 사이)에 위치할 수 있다.
# 즉 길이가 L인 문자열이 현재 편집기에 입력되어 있으면, 커서가 위치할 수 있는 곳은 L+1가지 경우가 있다.
# 이 편집기가 지원하는 명령어는 다음과 같다.
# L: 커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
# D: 커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
# B: 커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨) 삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임
# P $: $라는 문자를 커서 왼쪽에 추가함


import sys
from collections import deque

inputs = sys.stdin.readlines()
left_cursor = deque(inputs[0].strip()) #걍하면 뒤에 \n이 생겨서 이렇게함
right_cursor = deque("")    #걍하면 뒤에 \n이 생겨서 이렇게함
args = list(map(str.split, inputs[2:]))

for arg in args:
    if arg[0] == "L" and len(left_cursor) > 0:
        right_cursor.appendleft(left_cursor.pop())
    elif arg[0] == "D" and len(right_cursor) > 0:
        left_cursor.append(right_cursor.popleft())
    elif arg[0] == "B" and len(left_cursor) > 0:
        left_cursor.pop()
    #이거 걍 else하면 L,D,B여도 deque의 크기가 0이면 else가 실행됨(list index 벗어남)
    elif arg[0] == "P":
        left_cursor.append(arg[1])

#이거 그냥하면 right_cursor 뒤에 \n이 붙던데??
sys.stdout.write('"' + ''.join(left_cursor) + ''.join(right_cursor) + '"')
