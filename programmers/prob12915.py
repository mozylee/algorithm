# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/12915
# 문제: 문자열 내 마음대로 정렬하기
# 레벨: 1

def solution(strings, n):
    return sorted(sorted(strings), key=lambda x: x[n])
