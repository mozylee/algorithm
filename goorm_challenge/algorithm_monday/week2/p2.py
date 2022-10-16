from collections import deque
import sys


read = sys.stdin.readline

read()
s = deque(read().rstrip())
stack = []

while s:
    first = s.popleft()
    if not stack or stack[-1] != first:
        stack.append(first)

print(len(stack))
