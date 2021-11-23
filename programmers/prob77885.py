def solution(numbers: list) -> list:
    return list(map(get_minimum_bigger_num, numbers))


def get_minimum_bigger_num(x: int) -> int:
    bin_x = "0" + bin(x)[2:]
    position = len(bin_x) - 1 - bin_x.rindex("0")
    return x + 2 ** position - (2 ** (position - 1) if position > 0 else 0)


test_case = [2, 7]
# [3,11]
print(solution(test_case))
