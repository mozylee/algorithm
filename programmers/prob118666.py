from collections import defaultdict

indicator = {0: ('R', 'T'), 1: ('C', 'F'), 2: ('J', 'M'), 3: ('A', 'N')}


def get_score(survey: str, choice: int):
    if choice < 4:
        return survey[0], 4-choice
    return survey[1], choice-4


def solution(survey, choices):
    scores = defaultdict(int)

    for s, c in zip(survey, choices):
        chosen, score = get_score(s, c)
        scores[chosen] += score

    return "".join(min(indicator[i], key=lambda x: (-scores[x], x)) for i in range(4))


test_cases = [[["AN", "CF", "MJ", "RT", "NA"], [5, 3, 2, 7, 5]],
              [["TR", "RT", "TR"], [7, 1, 3]]]
# "TCMA"
# "RCJA"
for s, c in test_cases:
    print(solution(s, c))