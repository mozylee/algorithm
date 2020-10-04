# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/12901
# 문제: 2016년
# 레벨: 1

from datetime import date


def solution(a, b):
    return ['FRI', 'SAT', 'SUN', 'MON', 'TUE', 'WED', 'THU'][(date(2016, a, b) - date(2016, 1, 1)).days % 7]
