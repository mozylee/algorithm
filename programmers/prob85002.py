def solution(weights, head2head):
    winlates = [getWinlates(i, h, weights) for i, h in enumerate(head2head)]
    print(winlates)
    return sorted(range(1, len(weights)+1), key=lambda x: (-winlates[x-1][0], -winlates[x-1][1], -weights[x-1], x))


def getWinlates(i, h2h, weights):
    bouts = 0
    win = 0
    win_heavy = 0
    for j, h in enumerate(h2h):
        if h == 'N':
            continue
        bouts += 1
        if h == 'W':
            win += 1
            if weights[i] < weights[j]:
                win_heavy += 1
    return win/bouts if bouts > 0 else 0, win_heavy
