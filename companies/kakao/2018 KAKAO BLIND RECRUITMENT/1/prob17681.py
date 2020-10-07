# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/17681
# 문제: 비밀지도
# 레벨: 1

def solution(n, arr1, arr2):
    return [''.join(['#' if int(c) else ' ' for c in bin(a | b)[2:].zfill(n)]) for a, b in zip(arr1, arr2)]
