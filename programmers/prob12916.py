# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/12916
# 문제: 문자열 내 p와 y의 개수
# 레벨: 1

def solution(s):
    return s.lower().count('p') == s.lower().count('y')
