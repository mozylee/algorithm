# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/12985
# 문제: 예상 대진표
# 레벨: 2

def make_even(n):
    return n + 1 if n % 2 == 1 else n


def solution(n, a, b):
    answer, (a, b) = 1, (a, b) if a > b else (b, a)
    a = make_even(a)
    b = make_even(b)
    while a - b > 1:
        a, b = -int(a // -2), -int(b // -2)
        answer += 1
        a = make_even(a)
        b = make_even(b)
    return answer


print(solution(4, 2, 3))
