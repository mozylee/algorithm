# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/42889
# 문제: 실패율
# 레벨: 1

from collections import Counter


def solution(N, stages):
    fail_ratio, head_count = dict(), len(stages)
    stage_count = Counter(stages)
    for stage in range(1, N + 1):
        fail_ratio[stage] = stage_count[stage] / head_count if head_count else 0
        head_count -= stage_count[stage]
    return sorted(fail_ratio.keys(), key=lambda x: fail_ratio[x], reverse=True)


print(solution(5, [2, 1, 2, 6, 2, 4, 3, 3]))
