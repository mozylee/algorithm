from functools import cmp_to_key
import sys
import re
from collections import deque

read = sys.stdin.readline
alphabets = 'AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz'
priority = {a: i for i, a in enumerate(alphabets)}


def parse_char(s: str) -> list:
    if s.isnumeric():
        return [s]
    return list(s)


def parse_line(s: str) -> list:
    ret = []
    for c in s:
        if c.isalpha():
            ret.append(c)
            continue

        if ret and ret[-1].isnumeric():
            ret[-1] += c
            continue
        ret.append(c)
    return ret


def compare_int(n1: str, n2: str) -> int:
    if int(n1) == int(n2):
        return len(n1)-len(n2)
    return int(n1)-int(n2)


def compare(s1: str, s2: str) -> int:
    s1 = parse_line(s1)
    s2 = parse_line(s2)
    length = min(len(s1), len(s2))

    for c1, c2 in zip(s1[:length], s2[:length]):
        if c1.isnumeric() and c2.isnumeric():
            if compare_int(c1, c2) == 0:
                continue
            return compare_int(c1, c2)
        if c1.isnumeric():
            return -1
        elif c2.isnumeric():
            return 1
        elif priority[c1] == priority[c2]:
            continue
        else:
            return priority[c1]-priority[c2]
    return len(s1)-len(s2)


N = int(read())

strings = [read().rstrip() for _ in range(N)]
print(*sorted(strings, key=cmp_to_key(compare)), sep="\n")