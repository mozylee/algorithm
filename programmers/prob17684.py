# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/17684
# 문제: 압축
# 레벨: 2

def solution(msg):
    answer, dictionary = [], [chr(65 + i) for i in range(26)]
    while msg:
        j = 1
        while msg[:j] in dictionary:
            j += 1
            if j > len(msg):
                break
        dictionary.append(msg[:j])
        answer.append(dictionary.index(msg[: j - 1]) + 1)
        msg = msg[j - 1:]
    return answer


print(solution('KAKAO'))
