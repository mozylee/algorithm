# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/12935
# 문제: 제일 작은 수 제거하기
# 레벨: 1

def solution(arr):
    return arr[:arr.index(min(arr))] + arr[arr.index(min(arr)) + 1:] or [-1]


print(solution([10]))