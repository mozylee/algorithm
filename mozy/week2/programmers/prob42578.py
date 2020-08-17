# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/42578
# 문제: 위장

from itertools import combinations


def solution(clothes):
    cloth_kinds = [kind for cloth_name, kind in clothes]
    return sum([len([x for x in combinations(cloth_kinds, i + 1) if len(x) == len(set(x))]) for i in range(len(set(cloth_kinds)))])


print(solution([["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]))
