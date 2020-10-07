# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/12948
# 문제: 핸드폰 번호 가리기
# 레벨: 1

def solution(phone_number):
    return '*' * (len(phone_number) - 4) + phone_number[-4:]
