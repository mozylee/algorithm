# 출처: https://www.acmicpc.net/problem/1074
# 문제: Z


n, r, c = map(int, input().split())
result = 0
while n > 0:
    n -= 1
    if r < 2 ** n:
        # 1사분면
        if c < 2 ** n:
            result += 0
        # 2사분면
        else:
            result += 2 ** (2 * n)
            c -= 2 ** n
    else:
        # 3사분면
        if c < 2 ** n:
            result += 2 ** (2 * n) * 2
            r -= 2 ** n
        # 4사분면
        else:
            result += 2 ** (2 * n) * 3
            r -= 2 ** n
            c -= 2 ** n

print(result)
