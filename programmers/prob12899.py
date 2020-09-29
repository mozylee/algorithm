# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/12899
# 문제: 124 나라의 숫자

def numeral_system(n, base):
    notation = '124'


def solution(n):
    answer = ''
    while n > 0:
        answer += str(n % 4)
        n //= 4
    answer = str(int(answer[1]) + 1) + answer[1:]
    return ''.join((reversed(answer)))


print(solution())
