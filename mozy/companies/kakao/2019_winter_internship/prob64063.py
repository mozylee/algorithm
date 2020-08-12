# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/64063
# 문제: 호텔 방 배정

def solution(k, room_number):
    answer = []
    # 원래는 rooms라는 list로 while문 조건돌리고 그랬음
    # rooms = [0 for i in range(k)]

    for guest in room_number:
        while any([guest == room for room in answer]):
            guest += 1
        answer.append(guest)
    print(answer)
    return answer


solution(10, [1, 3, 4, 1, 3, 1])
