# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/12909
# 문제: 올바른 괄호

def solution(s):
    stack = []
    for char in s:
        if char == ')' and stack and stack[-1] == '(':
            stack.pop()
            continue
        stack.append(char)
    return not stack
