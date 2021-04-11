# 출처: https://www.acmicpc.net/problem/4673
# 문제: 셀프 넘버


def split_number(n):
    return list(map(int, str(n)))


n = {i: 0 for i in range(1, 10000 + 1)}

for i in range(1, 10000 + 1):
    splited = split_number(i)
    if i + sum(splited) > 10000:
        continue
    n[i + sum(splited)] += 1
print("\n".join(str(key) for key, value in n.items() if value == 0))
