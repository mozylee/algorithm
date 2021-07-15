# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/17682
# 문제: 다트 게임
# 레벨: 1

import re


def solution(dartResult):
    answer, bonus = [], {'S': 1, 'D': 2, 'T': 3}

    for i, match in enumerate(re.finditer('\d+\w(\*|#)?', dartResult)):
        turn = list(match.group())
        if turn[1].isdigit():
            turn = [turn[0] + turn[1]] + turn[2:]

        answer.append(int(turn[0]) ** bonus[turn[1]])
        if len(turn) < 3:
            continue
        if turn[2] == '*':
            answer[-1] *= 2
            if i == 0:
                continue
            answer[i - 1] *= 2
        else:
            answer[-1] *= -1

    return sum(answer)


print(solution('1S2D*3T10S'))
