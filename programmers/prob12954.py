# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/12954
# 문제: x만큼 간격이 있는 n개의 숫자
# 레벨: 1

def solution(x, n):
    return x and list(range(x, x * (n + 1), x)) or [0] * n


print(solution(0, 5))
