# 출처: https://www.acmicpc.net/problem/2484
# 문제: 주사위 네개


def get_score(dices):
    if len(set(dices)) == 1:
        score = 50000 + 5000 * dices[0]
    elif len(set(dices)) == 2:
        if dices[1] == dices[2]:
            score = 10000 + 1000 * dices[1]
        else:
            score = 2000 + 500 * sum(dices) // 2
    elif len(set(dices)) == 3:
        key = -1
        for i in range(3):
            if dices[i] == dices[i + 1]:
                key = i
        score = 1000 + 100 * dices[key]
    else:
        score = 100 * dices[-1]
    return score


import sys

read = sys.stdin.readline

print(max(get_score(sorted(map(int, read().split()))) for _ in range(int(read()))))

