def hanoi(start, target, n):
    if n == 1:
        return [[start, target]]

    other = 6 - (start + target)
    return hanoi(start, other, n - 1) + [[start, target]] + hanoi(other, target, n - 1)


def solution(n):
    return hanoi(1, 3, n)


print(solution(3))
