# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/42577
# 문제: 전화번호 목록
# boj의 prob05052와 같은 문제인듯

def solution(phone_book):
    phones = sorted(phone_book, key=len)
    k = len(phones) - 1
    for i, v in enumerate(reversed(phones)):
        if v != len(phones[-1]):
            k -= i + 1
            break

    for i, number in enumerate(phones[:k + 1]):
        for another_number in phones[i + 1:]:
            if number == another_number[:len(number)]:
                return False
    return True


print(solution(["12", "123", "1235", "567", "88"]))
