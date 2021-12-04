prize = {7 - i: i for i in range(1, 7)}
prize[0] = 6


def solution(lottos, win_nums):
    zero = count_zero(lottos)
    selected = 0
    for l in lottos:
        if l in win_nums:
            selected += 1

    return [prize[selected + zero], prize[selected]]


def count_zero(arr):
    cnt = 0
    for i in arr:
        if i == 0:
            cnt += 1
    return cnt


test_case = [
    [[44, 1, 0, 0, 31, 25], [31, 10, 45, 1, 6, 19]],  # [3, 5]
    [[0, 0, 0, 0, 0, 0], [38, 19, 20, 40, 15, 25]],  # [1, 6]
    [[45, 4, 35, 20, 3, 9], [20, 9, 3, 45, 4, 35]],  # [1, 1]
]

for l, w in test_case:
    print(solution(l, w))
