# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/42839
# 문제: 카펫

from math import sqrt


def solution(brown, yellow):
    answer = []
    x_plus_y = brown // 2 + 2
    xy = brown + yellow
    for y in range(1, int(sqrt(xy)) + 1):
        if xy % y == 0 and xy // y + y == x_plus_y:
            return [xy // y, y]
    return answer


print(solution(10, 2))
