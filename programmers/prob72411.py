from collections import defaultdict
from itertools import combinations


courses = {i: defaultdict(int) for i in range(1, 11)}


def make_course(order, size):
    combi = list(combinations(sorted(order), size))
    for c in combi:
        courses[size]["".join(c)] += 1


def solution(orders, course):
    # 여기부터 두줄은 테스트용 (사실 있어도 상관 없음)
    global courses
    courses = {i: defaultdict(int) for i in range(1, 11)}

    for o in orders:
        for c in course:
            make_course(o, c)

    print(courses)
    ret = []
    for c in course:
        if(len(courses[c]) < 1):
            continue
        most_chosen = max(courses[c].values())
        ret += list(filter(lambda x: 1 < courses[c]
                    [x] == most_chosen, courses[c].keys()))
    return sorted(ret)


cases = [[["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"], [2, 3, 4]],
         [["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"], [2, 3, 5]],
         [["XYZ", "XWY", "WXA"], [2, 3, 4]]]

for o, c in cases:
    print(solution(o, c))
    print("--------------")
