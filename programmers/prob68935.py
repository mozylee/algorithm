def solution(n):
    return get_reversed_decimal((get_trinary(n)))


def get_trinary(n):
    trinary = ""
    while n > 0:
        trinary = str(n % 3) + trinary
        n //= 3
    return trinary


def get_reversed_decimal(string):
    n = 0
    for i, c in enumerate(string):
        n += 3 ** i * int(c)
    return n


test_case = [45, 125]  # 7  # 229
for t in test_case:
    print(solution(t))
