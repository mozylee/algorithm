# 출처: programmers. https://programmers.co.kr/learn/courses/30/lessons/42888
# 문제: 오픈채팅방
# 레벨: 2

def change_log(users, answer, user_log, uid):
    for index in user_log[uid]:
        answer[index][0] = users[uid]


def solution(record):
    answer, users, user_log = [], {}, {}
    index = 0
    for command in record:
        re = command.split()
        if re[0] == "Leave":
            answer.append([users[re[1]], '님이 나갔습니다.'])
            user_log[re[1]].append(index)
            index += 1
        elif re[0] == "Enter":
            if re[1] not in users:
                users[re[1]] = re[2]
                user_log[re[1]] = []
            elif re[2] != users[re[1]]:
                users[re[1]] = re[2]
                change_log(users, answer, user_log, re[1])
            answer.append([users[re[1]], '님이 들어왔습니다.'])
            user_log[re[1]].append(index)
            index += 1
        else:
            users[re[1]] = re[2]
            change_log(users, answer, user_log, re[1])

    return [log[0] + log[1] for log in answer]


print(solution(
    ["Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"]))
