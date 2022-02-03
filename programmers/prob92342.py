from itertools import combinations_with_replacement

scores = [i for i in range(10 + 1)]


def solution(n, info):
    max_score = 0
    case = None
    for r in combinations_with_replacement(scores, n):
        rion = make_list(r)
        rion_score = sum_score(info, rion)
        if rion_score < max_score:
            continue
        if rion_score > max_score:
            max_score = rion_score
            case = rion
    return [-1] if case is None else case


def make_list(rion) -> tuple:
    ret = [0] * 11
    for r in rion:
        ret[10 - r] += 1
    return ret


def sum_score(info, rion) -> int:
    sum_r, sum_a = 0, 0
    for i, (a, r) in enumerate(zip(info, rion)):
        if a + r == 0:
            continue
        if r > a:
            sum_r += 10 - i
        else:
            sum_a += 10 - i
    return sum_r - sum_a


test_cases = [
    [5, [2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0]],
    [1, [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]],
    [9, [0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1]],
    [10, [0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3]],
]
# [0,2,2,0,1,0,0,0,0,0,0]
# [-1]
# [1,1,2,0,1,2,2,0,0,0,0]
# [1,1,1,1,1,1,1,1,0,0,2]

for n, info in test_cases:
    print(solution(n, info))
