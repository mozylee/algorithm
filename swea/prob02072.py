# 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5QSEhaA5sDFAUq
# 문제: 홀수만 더하기


import sys

read = sys.stdin.readline


for i in range(int(read())):
    print(f"#{i+1}", sum(filter(lambda x: x % 2 == 1, map(int, read().split()))))

