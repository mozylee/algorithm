# 출처: https://www.acmicpc.net/problem/2504
# 문제: 괄호의 값


from collections import deque
import sys

expression = deque(sys.stdin.readline().rstrip())
data = {")": (2, "("), "]": (3, "[")}
stack = deque()
print(*stack)
for ch in expression:
    if ch in ("(", "["):
        stack.append(ch)
    else:
        nums = 0
        while stack:
            top = stack.pop()
            if top == data[ch][1]:
                if not nums:
                    nums = 1
                stack.append(data[ch][0] * nums)
                break
            elif top in ("(", "["):
                print(0)
                exit(0)
            nums += top
    print(ch, ":", *stack)

for ch in "([])":
    if ch in stack:
        print(0)
        exit(0)
print(sum(stack))
