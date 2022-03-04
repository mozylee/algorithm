from collections import defaultdict


gem_check = defaultdict(int)


def solution(gems: list) -> list:
    left, right = 0, 0
    gem = len(set(gems))
    answer = []

    gem_count = 1
    gem_check[gems[0]] += 1
    while left <= right:
        if gem_count < gem and right<len(gems)-1:
            right += 1
            gem_count += 1 if gem_check[gems[right]] == 0 else 0
            gem_check[gems[right]] += 1
        else:
            if gem_count == gem:
                answer.append((left+1, right+1))
            gem_count += -1 if gem_check[gems[left]] == 1 else 0
            gem_check[gems[left]] -= 1
            left += 1

    return min(answer, key=lambda x: (x[1]-x[0], x[0]))


test_cases = [["DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"],
              ["AA", "AB", "AC", "AA", "AC"],
              ["XYZ", "XYZ", "XYZ"],
              ["ZZZ", "YYY", "NNNN", "YYY", "BBB"],	]
# [3, 7]
# [1, 3]
# [1, 1]
# [1, 5]
for t in test_cases:
    print(solution(t))
    gem_check = defaultdict(int)
