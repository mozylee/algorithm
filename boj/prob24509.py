import sys


read = sys.stdin.readline

subjects = ["Korean", "English", "Math", "Science"]

N = int(read())

students = {}
for _ in range(N):
    i, *scores = map(int, read().rstrip().split())
    students[i] = {subjects[j]: score for j, score in enumerate(scores)}

ans = []
for s in subjects:
    sorted_students = sorted(
        students.keys(), key=lambda x: (-students[x][s], x))

    for student in sorted_students:
        if student in ans:
            continue
        ans.append(student)
        break

print(*ans, sep=" ")
