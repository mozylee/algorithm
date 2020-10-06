# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/12931
# 문제: 자릿수 더하기
# 레벨: 1

def solution(n):
    return sum([int(c) for c in str(n)])
