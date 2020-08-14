# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/42839
# 문제: 소수 찾기

from itertools import permutations


def is_prime(num):
    if num < 2:
        return False
    if num < 4:
        return True
    if num % 2 == 0:
        return False

    for i in range(3, num // 2 + 1, 2):
        if num % i == 0:
            return False
    return True


def solution(numbers):
    answer = 0
    nums = []

    for i in range(len(numbers)):
        per = list(permutations(list(numbers), i + 1))
        for num in per:
            n = int(''.join(num))
            if not any([n == i for i in nums]):
                nums.append(n)
    for num in nums:
        if is_prime(num):
            answer += 1
    print(answer)
    return answer


solution('0011')
