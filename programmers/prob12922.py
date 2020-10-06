# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/12922
# 문제: 수박수박수박수박수박수?
# 레벨: 1

def solution(n):
    # return '수박' * (n // 2) + '수' * (n%2)
    return '수박' * (n // 2) + '수' * (1 if n % 2 == 1 else 0)
