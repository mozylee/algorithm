# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/12912
# 문제: 두 정수 사이의 합
# 레벨: 1

def solution(a, b):
    if a == b:
        return a
    a, b = (a, b) if a > b else (b, a)
    return a * (a + 1) // 2 - b * (b - 1) // 2
