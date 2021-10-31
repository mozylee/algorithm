def binary_search(h: int, l: list) -> int:
    left, right = 0, len(l) - 1
    while left <= right:
        mid = (left + right) // 2
        if l[mid] < h:
            left = mid + 1
        elif l[mid] == h:
            right -= 1
        else:
            right = mid - 1
    return left


def solution(citations):
    sorted_citations = sorted(citations)
    min_h, max_h = 0, max(citations)
    length = len(citations)
    ret = 0
    while min_h <= max_h:
        h = (min_h + max_h) // 2
        index = binary_search(h, sorted_citations)
        amount = length - index
        if amount < h:
            max_h = h - 1
        else:
            ret = max(ret, h)
            min_h += 1
    return ret


def solution2(citations):
    h_index = min(max(citations), len(citations))
    for h in range(h_index, -1, -1):
        for i, c in enumerate(sorted(citations, reverse=True)):
            if i + 1 >= h and c >= h:
                return h


test_cases = [
    [3, 0, 6, 1, 5],
    [5, 5, 5, 5, 5],
    [5, 4, 3, 2, 1],
    [0, 0, 0, 0, 1],
    [0, 0, 0, 0, 0],
    [9, 9, 9, 12],
    [1, 1, 5, 7, 6],
]
# 3
# 5
# 3
# 1
# 0
# 4
# 3

for t in test_cases:
    print(solution(t))
    print(solution2(t))
