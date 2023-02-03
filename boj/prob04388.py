import sys


read = sys.stdin.readline

ans = []

a, b = map(int, read().split())

while a+b > 0:
    a, b = (a, b) if a > b else (b, a)
    count = 0

    carry = 0
    while a+b > 0:
        a, _a = divmod(a, 10)
        b, _b = divmod(b, 10)

        if _a+_b + carry > 9:
            count += 1
            carry = 1
            continue
        carry = 0

    ans.append(count)
    a, b = map(int, read().split())

print(*ans, sep="\n")
