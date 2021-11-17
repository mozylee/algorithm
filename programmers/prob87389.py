def solution(n):
    for i in range(1, n):
        if n % i == 1:
            return i


test_cases = [10, 12]
# 3
# 11

for t in test_cases:
    print(solution(t))
