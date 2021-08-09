from collections import Counter


def solution(scores):
    answer = ''
    amount = len(scores)
    totals = [[scores[j][i] for j in range(amount)] for i in range(amount)]
    student_self = [scores[i][i] for i in range(amount)]
    for this_score, score in zip(student_self, totals):
        counter = Counter(score)
        total_score = sum(score)
        length = amount
        if(this_score in (max(score), min(score)) and counter[this_score] == 1):
            length -= 1
            total_score -= this_score
        answer += get_grade(total_score/length)
    return answer


def get_grade(n):
    if(n >= 90):
        return 'A'
    elif(n >= 80):
        return 'B'
    elif(n >= 70):
        return 'C'
    elif(n >= 50):
        return 'D'
    else:
        return 'F'