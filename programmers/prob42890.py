from itertools import combinations


def solution(relation: list) -> int:
    rows = len(relation)
    candidate_keys = set()
    row_set = set()
    key_indexes = sorted(get_key_indexes(len(relation[0])), key=len)
    for key_index in key_indexes:
        row_set.update(map(lambda x: make_key(key_index, x), relation))
        if len(row_set) == rows and is_minimum(key_index, candidate_keys):
            candidate_keys.add(key_index)
        row_set.clear()
    return len(candidate_keys)


def is_minimum(key_index: tuple, candidate_keys: set) -> bool:
    for c in candidate_keys:
        if len(c) >= len(key_index):
            continue
        if is_exist(c, key_index):
            return False
    return True


def is_exist(c: tuple, key_index: tuple) -> bool:
    count = 0
    for attr in c:
        if attr in key_index:
            count += 1
    return count == len(c)


def make_key(key_index: tuple, row: list) -> str:
    return "/".join(attribute for i, attribute in enumerate(row) if i in key_index)


def get_key_indexes(columns: int) -> set:
    key_indexes = set()
    for i in range(1, columns + 1):
        key_indexes.update(combinations(range(columns), i))
    return key_indexes


test_case = [
    ["100", "ryan", "music", "2"],
    ["200", "apeach", "math", "2"],
    ["300", "tube", "computer", "3"],
    ["400", "con", "computer", "4"],
    ["500", "muzi", "music", "3"],
    ["600", "apeach", "music", "2"],
]
# 2
print(solution(test_case))
