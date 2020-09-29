# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/62048
# 문제: 멀쩡한 사각형

def solution(w, h):
    big, gcd = (w, h) if w > h else (h, w)

    # math 모듈이 있음. math.gcd(a,b)를 통해 편하게 구현 가능
    while gcd > 0:
        n = big % gcd
        big = gcd
        gcd = n
    return w * h - (w + h - big)


solution(8, 12)
