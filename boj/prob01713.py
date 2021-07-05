# 출처: https://www.acmicpc.net/problem/1713
# 문제: 후보 추천하기


import sys

read = sys.stdin.readline

students = {}
n = int(read())
read()
for i, vote in enumerate(map(int, read().split())):
    if vote not in students:
        if len(students.keys()) >= n:
            min_student = min(students, key=lambda x: tuple(students[x]))
            del students[min_student]
        students[vote] = [1, i]
        continue
    students[vote][0] += 1

print(*sorted(students), sep=" ")

