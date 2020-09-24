# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/12911
# 문제: 다음 큰 숫자

def solution(n):
    bin_n = bin(n)[2:]
    num0, num1 = bin_n.count('0'), bin_n.count('1')
    if num0 == 0:
        return int('10' + '1' * (num1 - 1), base=2)
    if num1 == 1:
        return n * 2

    index = bin_n[1:].find('1') - 1

    return int('1' + '0' * index + '1' + '0' * (num0 - index) + '1' * (num1 - 2), base=2) if index > 0 else int(
        '10' + '0' * num0 + '1' * (num1-1), base=2)


print(solution(3))
