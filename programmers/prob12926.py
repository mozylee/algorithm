# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/12926
# 문제: 시저 암호
# 레벨: 1

def solution(s, n):
    answer = []
    for c in s:
        if not c.isalpha():
            answer.append(' ')
        elif c.islower():
            answer.append(chr((ord(c) + n - 97) % 26 + 97))
        else:
            answer.append(chr((ord(c) + n - 65) % 26 + 65))
    return ''.join(answer)
