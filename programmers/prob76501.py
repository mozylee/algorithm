def solution(absolutes, signs):
    return sum(a if signs[i] else -a for i, a in enumerate(absolutes))


test_cases = [[[4, 7, 12], [True, False, True]], [[1, 2, 3], [False, False, True]]]

# 9
# 0

for a, s in test_cases:
    print(solution(a, s))
