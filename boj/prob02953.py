import sys


read = sys.stdin.readline

students = [(i, sum(map(int,read().split()))) for i in range(1,6)]
print(*max(students, key=lambda x:x[1]))