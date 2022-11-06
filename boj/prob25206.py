import sys


read = sys.stdin.readline

grades = {"A+":	4.5,
          "A0":	4.0,
          "B+":	3.5,
          "B0":	3.0,
          "C+":	2.5,
          "C0":	2.0,
          "D+":	1.5,
          "D0":	1.0,
          "F":	0.0, }

sum_score = 0
sum_grade = 0

for _ in range(20):
    __, score, grade = read().rstrip().split()

    if grade == 'P':
        continue

    score = float(score)
    sum_score += score
    sum_grade += score * grades[grade]

print(sum_grade/sum_score)