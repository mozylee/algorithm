def solution(sizes):
    sizes = [sorted(s) for s in sizes]
    max_x = max(x for x, _ in sizes)
    max_y = max(y for _, y in sizes)
    return max_x * max_y


test_cases = [[[60, 50], [30, 70], [60, 30], [80, 40]],
              [[10, 7], [12, 3], [8, 15], [14, 7], [5, 15]],
              [[14, 4], [19, 6], [6, 16], [18, 7], [7, 11]]]

for t in test_cases:
    print(solution(t))
