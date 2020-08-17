# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/42578
# 문제: 위장

from math import factorial
from collections import Counter
from itertools import combinations


def solution(clothes):
    answer = 0
    clothes_kind = [kind for cloth_name, kind in clothes]
    kind = len(Counter(clothes_kind).keys())

    for i in range(kind):
        answer += len([x for x in combinations(clothes_kind, i + 1) if len(x) == len(set(x))])
    return answer


print(solution([["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]))
