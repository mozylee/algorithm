from collections import deque

parenthesises = {")": "(", "}": "{", "]": "["}


def solution(s: str) -> int:
    return sum(is_right_parenthesis(deque(s), i) for i in range(len(s)))


def is_right_parenthesis(d: deque, n: int) -> int:
    d.rotate(n)
    stack = []
    while d:
        token = d.popleft()
        if token in parenthesises.values():
            stack.append(token)
            continue
        if not stack or stack[-1] != parenthesises[token]:
            return 0
        stack.pop()
    return 1 if not stack else 0


test_cases = [
    "[](){}",
    "}]()[{",
    "[)(]",
    "}}}",
]
# 3
# 2
# 0
# 0

for t in test_cases:
    print(solution(t))
