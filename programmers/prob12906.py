# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/12906
# 문제: 같은 숫자는 싫어
# 레벨: 1

def solution(arr):
    return [arr[0]] + [value for i, value in enumerate(arr[1:]) if value != arr[i]]


print(solution([1, 1, 3, 3, 0, 1, 1]))
