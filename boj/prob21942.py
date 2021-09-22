import sys
from datetime import datetime

read = sys.stdin.readline
MIN_TIME = datetime(2021, 1, 1, 0, 0, 0)


def init(s: list) -> tuple:
    N, L, F = s
    N, F = map(int, (N, F))

    ddd, hh, mm = int(L[:3]), *map(int, L[4:].split(":"))
    mm += 60 * hh + 24 * 60 * ddd
    return N, mm, F


def parse_line(line: str) -> tuple:
    d, h, p, n = line.rstrip().split()

    year, month, day = map(int, d.split("-"))
    hh, mm = map(int, h.split(":"))
    delta = datetime(year, month, day, hh, mm, 0) - MIN_TIME
    minutes = delta.seconds // 60 + delta.days * 24 * 60
    return minutes, p, n


N, L, F = init(read().split())
fines, logs = dict(), dict()
for _ in range(N):
    minutes, P, M = parse_line(read())
    key = P + " " + M
    if key not in logs.keys():
        logs[key] = minutes
        continue
    term = minutes - logs[key] - L
    del logs[key]
    if term <= 0:
        continue
    if M not in fines.keys():
        fines[M] = 0
    fines[M] += term * F


print("\n".join(k + " " + str(v)
      for k, v in sorted(fines.items())) if fines else -1)
