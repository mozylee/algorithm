# 출처: https://www.acmicpc.net/problem/17269
# 문제: 이름궁합 테스트

import sys

sys.setrecursionlimit(100000)

alphabet = [
    3,
    2,
    1,
    2,
    3,
    3,
    2,
    3,
    3,
    2,
    2,
    1,
    2,
    2,
    1,
    2,
    2,
    2,
    1,
    2,
    1,
    1,
    1,
    2,
    2,
    1,
]

alphabets = {chr(ord("A") + i): str(a) for i, a in enumerate(alphabet)}
names = [input(), input()]
nums = ""
for i, j in zip(names[0], names[1]):
    nums += alphabets[i] + alphabets[j]


def get_percent(s):
    if s == "100" or len(s) < 3:
        print(s)
        return
    res = ""
    for c1, c2 in zip(s[:-1], s[1:]):
        res += str((int(c1) + int(c2)) % 10)
    get_percent(res)


get_percent(nums)

