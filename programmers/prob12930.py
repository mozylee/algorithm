# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/12930
# 문제: 이상한 문자 만들기
# 레벨: 1

def solution(s):
    return ' '.join([''.join([c.lower() if i % 2 == 1 else c.upper() for i, c in enumerate(string)]) for string in s.split(' ')])
