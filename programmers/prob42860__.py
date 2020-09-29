# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/42860
# 문제: 조이스틱

def solution(name):
    moves = {chr(65 + fw): fw if fw < bw else bw for fw, bw in zip(range(0, 26), range(26, 0, -1))}
    name = [moves[char] for char in name]
    left, right = name[0], name[0] + 1
    name.pop(0)

    cursor = 1
    while not sum(name[cursor:]) == 0:
        left += 1 + name[cursor]
        cursor += 1

    cursor = 1
    while not sum(name[:-cursor]) == 0:
        right += 1 + name[cursor]
        cursor += 1

    return min(left, right) - 1
