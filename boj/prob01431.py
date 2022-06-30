import sys


read = sys.stdin.readline


def sum_serial_numbers(s: str) -> int:
    ans = 0
    for c in s:
        if c.isnumeric():
            ans += int(c)
    return ans


serial_numbers = list(read().rstrip() for _ in range(int(read())))
s = {n: sum_serial_numbers(n) for n in serial_numbers}

print("\n".join(sorted(serial_numbers, key=lambda x: (len(x), s[x], x))))
