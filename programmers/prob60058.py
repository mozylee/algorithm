# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/60058
# 문제: 괄호 변환

def separate(p):
    index = 1
    count = 1 if p[0] == '(' else -1
    while count != 0:
        if p[index] == '(':
            count += 1
        else:
            count -= 1
        index += 1
    return p[:index], p[index:]


def is_right(p):
    stack = []
    for char in p:
        if char == ')' and stack and stack[-1] == '(':
            stack.pop()
            continue
        stack.append(char)
    return not stack


def reverse(p):
    return ''.join([')' if char == '(' else '(' for char in p[1:-1]])


def solution(p):
    if not p:
        return ''

    u, v = separate(p)
    # print('u=' + u, 'v=' + v)

    if is_right(u):
        # print('is right')
        return u + solution(v)
    return '(' + solution(v) + ')' + reverse(u)


print(solution(')('))
