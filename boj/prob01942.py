import sys

read = sys.stdin.readline


def solution(start: tuple, end: tuple) -> int:
    ans = 0
    for t in get_times(start, end):
        ans += 1 if t % 3 == 0 else 0
    return ans


def get_times(s: tuple, e: tuple) -> list:
    times = []
    h, m, s = s
    while (h, m, s) != e:
        times.append(get_time_integer(h, m, s))
        h, m, s = get_next_time(h, m, s)
    return times + [get_time_integer(h, m, s)]


def get_next_time(h, m, s):
    s += 1
    if s == 60:
        m += 1
        s = 0
    if m == 60:
        h = (h + 1) % 24
        m = 0
    return h, m, s


def get_time_integer(h, m, s):
    return h * 10000 + m * 100 + s


def parse_time(s: str) -> tuple:
    h, m, s = map(int, s.split(":"))
    return h, m, s


for _ in range(3):
    print(solution(*map(parse_time, read().rstrip().split(" "))))
