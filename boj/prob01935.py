# 출처: https://www.acmicpc.net/problem/1935
# 문제: 후위 표기식2


import sys

n = int(sys.stdin.readline())
suffix_expression = sys.stdin.readline().rstrip()
nums = {chr(ord("A") + i): sys.stdin.readline().rstrip() for i in range(n)}
stack = []

for char in suffix_expression:
    if char.isalpha():
        stack.append(nums[char])
    else:
        operand2 = stack.pop()
        operand1 = stack.pop()
        stack.append(f"({operand1}{char}{operand2})")
        # stack.append(eval(str(operand1) + char + str(operand2)))

print(format(stack.pop(), ".2f"))
