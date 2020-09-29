# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/12977
# 문제: 소수 만들기
# 레벨: 2

from itertools import combinations


def is_prime(num):
    if num % 2 == 0 or num % 3 == 0:
        return False

    for i in range(3, int(num ** 0.5) + 1, 2):
        if num % i == 0:
            return False
    return True


def solution(nums):
    return sum([1 for a, b, c in combinations(nums, 3) if is_prime(a + b + c)])


print(solution([1, 2, 7, 6, 4]))
