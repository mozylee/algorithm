# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/12903
# 문제: 가운데 글자 가져오기
# 레벨: 1

def solution(s):
    return s[len(s) // 2] if len(s) % 2 == 1 else s[len(s) // 2 - 1:len(s) // 2 + 1]


print(solution('abcdef'))
