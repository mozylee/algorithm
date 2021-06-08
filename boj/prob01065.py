# 출처: https://www.acmicpc.net/problem/1065
# 문제: 한수


def split_number(n):
    return list(map(int, str(n)))


def is_hansu(n):
    if n // 10 == 0:
        return True
    splited_n = split_number(n)
    common = splited_n[0] - splited_n[1]
    for i in range(1, len(splited_n) - 1):
        if splited_n[i] - splited_n[i + 1] != common:
            return False
    return True


result = 0

for i in range(1, int(input()) + 1):
    if is_hansu(i):
        result += 1
print(result)

