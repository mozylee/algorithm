from itertools import product
from bisect import bisect_left


def find_ge(iterable, x):
    i = bisect_left(iterable, x)
    if i != len(iterable):
        return iterable[i]
    return -1


def find_index(iterable, value):
    ge = find_ge(iterable, value)
    if ge > -1:
        return iterable.index(ge)
    return -1


def solution(info, query):
    answer = []
    criteria = [['java', 'python', 'cpp', '-'], ['backend', 'frontend', '-'], ['junior', 'senior', '-'],
                ['chicken', 'pizza', '-']]
    info_dict = {' '.join(key): [] for key in product(*criteria)}
    for applicant in info:
        lang, position, career, soul_food, score = applicant.split()
        my_criteria = [[lang, '-'], [position, '-'], [career, '-'], [soul_food, '-']]
        for c in product(*my_criteria):
            key = ' '.join(c)
            info_dict[key].append(int(score))

    remove_keys = []
    for k, v in list(info_dict.items()):
        if v:
            v.sort()
            continue
        remove_keys.append(k)
    map(info_dict.pop, remove_keys)

    for q in query:
        lang, _, position, _, career, _, soul_food, score = q.split()
        key = ' '.join([lang, position, career, soul_food])
        index = find_index(info_dict[key], int(score))
        answer.append(len(info_dict[key]) - index if index > -1 else 0)
    return answer