from functools import cmp_to_key
import sys
import re
from collections import deque

# UNSOLVED!!!!!!!!!!!!!!!!
read = sys.stdin.readline
re_number = re.compile("\d+")
alphabets = 'AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz'
priority = {a:i for i, a in enumerate(alphabets)}


def parse_char(s: str) -> list:
    if s.isnumeric():
        return [s]
    return list(s)


def parse_line(s: str) -> list:
    numbers = deque(re_number.findall(s))
    strings = deque(re_number.split(s))

    q1, q2 = (strings, numbers) if s[0].isalpha() else (numbers, strings)
    ret = parse_char(q1.popleft())

    while q1:
        ret.extend(parse_char(q2.popleft()))
        ret.extend(parse_char(q1.popleft()))
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
        elif priority[c1]==priority[c2]:
            continue
        else:
            return priority[c1]-priority[c2]
    return len(s1)-len(s2)


N = int(read())

strings = [read().rstrip() for _ in range(N)]
print(*sorted(strings, key=cmp_to_key(compare)), sep="\n")
