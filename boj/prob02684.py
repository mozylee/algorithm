from collections import defaultdict
import sys


read = sys.stdin.readline
cases = ("TTT", "TTH", "THT", "THH", "HTT", "HTH", "HHT", "HHH")


def get_case_count(s: str):
    case_count = defaultdict(int)

    for i in range(40-2):
        case_count[s[i:i+3]] += 1

    for i in cases:
        print(case_count[i], end=" ")
    print()


for i in range(int(read())):
    get_case_count(read().rstrip())
