# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/12941
# 문제: 최솟값 만들기
# 레벨: 2

def solution(A, B):
    return sum([i * j for i, j in zip(sorted(A), sorted(B, reverse=True))])


print(solution([1, 4, 2], [5, 4, 4]))
