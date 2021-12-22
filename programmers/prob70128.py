def solution(a, b):
    return sum(i * j for i, j in zip(a, b))


test_case = [[[1, 2, 3, 4], [-3, -1, 0, 2]], [[-1, 0, 1], [1, 0, -1]]]

# 3
# -2
for a, b in test_case:
    print(solution(a, b))
