def solution(left, right):
    return sum(
        i if get_count_of_divisor(i) % 2 == 0 else -i for i in range(left, right + 1)
    )


def get_count_of_divisor(factor):
    count = 0
    root = factor ** (1 / 2)
    for i in range(1, int(root) + 1):
        if factor % i == 0:
            count += 2
    return count - 1 if root == int(root) else count


test_cases = [[13, 17], [24, 27]]
# 43
# 52
for l, r in test_cases:
    print(solution(l, r))
