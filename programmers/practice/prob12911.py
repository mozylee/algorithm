# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/12911
# 문제: 다음 큰 숫자

def solution(n):
    count1 = bin(n).count('1')
    n += 1
    while bin(n).count('1') != count1:
        n += 1
    return n

print(solution(6))
