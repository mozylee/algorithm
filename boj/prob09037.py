# 출처: https://www.acmicpc.net/problem/9037
# 문제: The Candy War


def check(array):
    pick = array[0]
    for v in array:
        if v != pick:
            return False
    return True


def make_even(array):
    for i, v in enumerate(array):
        if v % 2:
            array[i] += 1


def make_half(array):
    res = list(map(lambda x: x // 2, array))
    return res, res[1:] + [res[0]]


import sys

read = sys.stdin.readline

for _ in range(int(read())):
    n = int(read())
    candies = []
    for candy in map(int, read().split()):
        candies.append(candy + 1 if candy % 2 else candy)

    cycle = 0
    while not check(candies):
        candies = [h1 + h2 for h1, h2 in zip(*make_half(candies))]
        make_even(candies)
        cycle += 1

    print(cycle)

