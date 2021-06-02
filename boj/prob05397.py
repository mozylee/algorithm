# 출처: https://www.acmicpc.net/problem/5397
# 문제: 키로거


from collections import deque
import sys

read = sys.stdin.readline

for _ in range(int(read())):
    left_cursor, right_cursor = deque(), deque()
    key_log = read().rstrip()

    for key in key_log:
        if key == '<':
            if left_cursor:
                right_cursor.append(left_cursor.pop())
        elif key == '>':
            if right_cursor:
                left_cursor.append(right_cursor.pop())
        elif key == '-':
            if left_cursor:
                left_cursor.pop()
        else:
            left_cursor.append(key)
    left_cursor += reversed(right_cursor)
    print(''.join(left_cursor))
