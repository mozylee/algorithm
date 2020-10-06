# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/12921
# 문제: 소수 찾기
# 레벨: 1

def is_prime(n):
    if n < 4:
        return True
    if n % 2 == 0 or n % 3 == 0:
        return False

    for i in range(3, int(n ** 0.5) + 1, 2):
        if n % i == 0:
            return False
    return True


def solution(n):
    return sum([1 for i in range(2, n + 1) if is_prime(i)])
