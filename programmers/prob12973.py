def solution(s):
    stack = []
    for c in s:
        if not stack or stack[-1] != c:
            stack.append(c)
            continue
        stack.pop()
    return 1 if not stack else 0


test_cases = ["baabaa", "cdcd"]
# 1
# 0
for t in test_cases:
    print(solution(t))
