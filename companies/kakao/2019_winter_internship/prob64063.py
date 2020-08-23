# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/64063
# 문제: 호텔 방 배정

def solution(k, room_number):
    for i, v in enumerate(room_number):
        while any([v == room for room in room_number[:i]]):
            v += 1
        room_number[i] = v
    print(room_number)
    return room_number


solution(10, [1, 3, 4, 1, 3, 1])
