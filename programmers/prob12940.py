# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/12940
# 문제: 최대공약수와 최소공배수
# 레벨: 1

def solution(n, m):
    gcd, small = n > m and (n, m) or (m, n)
    while small > 0:
        num = gcd % small
        gcd = small
        small = num
    return [gcd, n * m // gcd]


print(solution(3, 12))
