from itertools import product
from bisect import bisect_left


def find_ge(iter, x):
    i = bisect_left(iter, x)
    if i != len(iter):
        return iter[i]
    return -1


def find_index(iter, value):
    ge = find_ge(iter, value)
    if ge > -1:
        return iter.index(ge)
    return -1


def solution(info, query):
    answer = []
    criteria = [['java', 'python', 'cpp'], ['backend', 'frontend'], ['junior', 'senior'], ['chicken', 'pizza']]
    info_map = {' '.join(key): [] for key in product(*criteria)}
    for applicant in info:
        index = applicant[::-1].index(' ')
        info_map[applicant[:-index - 1]].append(int(applicant[-index:]))
    for key in info_map.keys():
        info_map[key].sort()

    for q in query:
        lang, _, position, _, career, _, soul_food, score = q.split()
        if '-' in [lang, position, career, soul_food]:
            my_criteria, result = [[], [], [], []], 0
            if lang == '-':
                my_criteria[0] = criteria[0]
            else:
                my_criteria[0].append(lang)
            if position == '-':
                my_criteria[1] = criteria[1]
            else:
                my_criteria[1].append(position)
            if career == '-':
                my_criteria[2] = criteria[2]
            else:
                my_criteria[2].append(career)
            if soul_food == '-':
                my_criteria[3] = criteria[3]
            else:
                my_criteria[3].append(soul_food)

            for c in product(*my_criteria):
                key = ' '.join(c)
                index = find_index(info_map[' '.join(c)], int(score))
                result += len(info_map[key]) - index if index > -1 else 0
            answer.append(result)
        else:
            key = ' '.join([lang, position, career, soul_food])
            index = find_index(info_map[key], int(score))
            answer.append(len(info_map[key]) - index if index > -1 else 0)
    return answer