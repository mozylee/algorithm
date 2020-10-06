# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/12928
# 문제: 약수의 합
# 레벨: 1
# edge case: 0, 1, 4(정수 제곱근이 존재하는 경우)

def solution(n):
    return sum([i + (n // i if i != int(n ** 0.5) else 0) for i in range(1, int(n ** 0.5) + 1) if n % i == 0])
    # return sum([i for i in range(1, n + 1) if n % i == 0])


print(solution(4))
