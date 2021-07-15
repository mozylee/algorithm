# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/64064
# 문제: 불량 사용자

from itertools import product
from collections import Counter


def solution(user_id, banned_id):
    answer = []
    ids = [[] for i in banned_id]
    b = [v for i, v in Counter(banned_id).items() if v > 1]
    divider = 1
    for i in b:
        divider *= i

    for i, ban in enumerate(banned_id):
        for user in user_id:
            is_okay = True
            if len(ban) != len(user):
                continue
            for b, u in zip(ban, user):
                if b != '*' and b != u:
                    is_okay = False
                    break
            if is_okay:
                ids[i].append(user)
    ids = list(product(*ids))

    for i, combination in enumerate(ids):
        is_okay = True
        for j, v1 in enumerate(combination[:-1]):
            if not is_okay:
                break
            for v2 in combination[j + 1:]:
                if v1 == v2:
                    is_okay = False
                    break
        if is_okay:
            answer.append(combination)
    return len(answer)//divider


solution(["frodo", "fradi", "crodo", "abc123", "frodoc"], ["fr*d*", "*rodo", "******", "******"])
