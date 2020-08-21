# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/42578
# 문제: 위장

from collections import Counter
from functools import reduce


def solution(clothes):
    return reduce(lambda x, y: x * (y + 1), Counter([kind for cloth, kind in clothes]).values(), 1) - 1


print(solution([["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]))
