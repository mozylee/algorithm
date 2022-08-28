from datetime import datetime
import sys


read = sys.stdin.readline

students = {}

for _ in range(int(read())):
    name, day, month, year = read().rstrip().split()
    students[name] = datetime(int(year), int(month), int(day))

sorted_students = sorted(students.keys(), key=lambda x: students[x])
print(sorted_students[-1])
print(sorted_students[0])
