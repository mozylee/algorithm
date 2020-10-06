# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/12919
# 문제: 서울에서 김서방 찾기
# 레벨: 1

def solution(seoul):
    return '김서방은 {}에 있다'.format(seoul.index('Kim'))


print(solution(['a', 'b', 'c,', 'Kim']))
