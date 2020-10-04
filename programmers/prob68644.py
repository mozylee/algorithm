# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/68644
# 문제: 두 개 뽑아서 더하기
# 레벨: 1

from itertools import combinations


def solution(numbers):
    return list(set([sum(number_comb) for number_comb in combinations(numbers, 2)]))


