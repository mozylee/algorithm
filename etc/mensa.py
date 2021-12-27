# https://post.naver.com/viewer/postView.naver?volumeNo=32974958
from itertools import permutations


def get_location(colors: list) -> dict:
    location = [(0, 0), (0, 1), (1, 0), (1, 1), (1, 2), (2, 1), (2, 2)]
    return {c: l for c, l in zip(colors, location)}


def is_close(c1: tuple, c2: tuple) -> bool:
    return abs(c1[0] - c2[0] + c1[1] - c2[1]) == 1


def is_left(c1: tuple, c2: tuple) -> bool:
    return (c1[0] == c2[0] and c1[1] - c2[1] == -1) or (
        c1[1] == c2[1] and c1[0] - c2[0] == 1
    )


def is_every_color_changed(before, case):
    for color in case.keys():
        if before[color] == case[color]:
            return False
    return True


def print_case(case: dict):
    l = [[0] * 3 for _ in range(3)]
    for c in case.keys():
        i, j = case[c]
        l[i][j] = c


colors = ["RED", "YELLOW", "ORANGE", "GREEN", "PURPLE", "BLUE", "PINK"]
before = get_location(colors)

for c in permutations(colors):
    case = get_location(c)
    if not is_every_color_changed(before, case):
        continue
    if case["YELLOW"] != (1, 1):
        continue
    if case["GREEN"] not in ((0, 0), (0, 1), (1, 1)):
        continue
    if case["PINK"] not in ((2, 0), (1, 2)):
        continue
    if not is_close(case["PINK"], case["YELLOW"]) or not is_close(
        case["PINK"], case["ORANGE"]
    ):
        continue
    if not is_close(case["YELLOW"], case["BLUE"]) or not is_close(
        case["YELLOW"], case["PURPLE"]
    ):
        continue
    if not is_left(case["RED"], case["ORANGE"]):
        continue
    if not is_left(case["BLUE"], case["GREEN"]):
        continue
    print_case(case)
