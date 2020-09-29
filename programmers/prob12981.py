# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/12981
# 문제: 영어 끝말잇기
# 레벨: 2

def solution(n, words):
    for i, word in enumerate(words[1:]):
        if word in words[:i + 1] or word[0] != words[i][-1]:
            return [(i + 1) % n + 1, (i + 1) // n + 1]
    return [0, 0]


print(solution(3,
               ["tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"]))
