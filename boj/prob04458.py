import sys


read = sys.stdin.readline


def capitalize(s: str) -> str:
    return s[0].upper()+s[1:]


print(*(capitalize(read().rstrip()) for _ in range(int(read()))), sep="\n")
