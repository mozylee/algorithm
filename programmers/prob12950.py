# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/12950
# 문제: 행렬의 덧셈
# 레벨: 1

def solution(arr1, arr2):
    print(arr1[0][0], len(arr1[0]), len(arr1))
    return [[arr1[i][j] + arr2[i][j] for j in range(len(arr1[i]))] for i in range(len(arr1))]


print(solution([[1],[2]],[[3],[4]]))