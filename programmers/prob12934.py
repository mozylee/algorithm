# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/12934
# 문제: 정수 제곱근 판별
# 레벨: 1

def solution(n):
    return (int(n ** 0.5) + 1) ** 2 if n ** 0.5 == int(n ** 0.5) else -1
