def solution(numbers):
    return 45 - sum(numbers)


test_cases = [[1, 2, 3, 4, 6, 7, 8, 0], [5, 8, 4, 0, 6, 7, 9]]
# 14
# 6

for t in test_cases:
    print(solution(t))
