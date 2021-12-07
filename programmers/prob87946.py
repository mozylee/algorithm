from itertools import permutations


def solution(k, dungeons):
    answer = 0
    MAX = len(dungeons)
    for p in permutations(map(tuple, dungeons)):
        fatigue = k
        count = 0
        for required, consumption in p:
            if fatigue >= required:
                fatigue -= consumption
                count += 1
        answer = max(answer, count)
        if answer == MAX:
            break
    return answer


test_case = [80, [[80, 20], [50, 40], [30, 10]]]
# 3
k, d = test_case
print(solution(k, d))
