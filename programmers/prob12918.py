# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/12918
# 문제: 문자열 다루기 기본
# 레벨: 1

def solution(s):
    try:
        int(s)
    except ValueError:
        return False
    # return s.isdigit() and len(s) in [4,6]
    return len(s) in [4, 6]
