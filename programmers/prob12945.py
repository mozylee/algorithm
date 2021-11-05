fibo = [0, 1]
for i in range(2, 100000 + 1):
    fibo.append((fibo[i - 1] + fibo[i - 2]) % 1234567)


def solution(n):
    return fibo[n]


test_cases = [3, 5]
# 2
# 5
for t in test_cases:
    print(solution(t))
