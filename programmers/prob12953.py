# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/12953
# 문제: N개의 최소공배수
# 레벨: 2

def solution(arr):
    arr.sort()
    num_dict = {}
    for i, value in enumerate(arr):
        n = 2
        while value > 1:
            power = 0
            while value % n == 0:
                power += 1
                value //= n

            if power > 0:
                if n not in num_dict:
                    num_dict[n] = power
                elif power > num_dict[n]:
                    num_dict[n] = power
            n += 1

    result = 1
    for key, value in num_dict.items():
        result *= pow(key, value)
    return result


print(solution([39, 2, 7, 120]))
