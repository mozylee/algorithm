# Backjoon Online Judge: https://www.acmicpc.net/problem/2920
# 문제: 음계

# 1부터 8까지 차례대로 연주한다면 ascending, 8부터 1까지 차례대로 연주한다면 descending, 둘 다 아니라면 mixed 이다.
# 연주한 순서가 주어졌을 때, 이것이 ascending인지, descending인지, 아니면 mixed인지 판별하는 프로그램을 작성하시오.


a = input()

#이렇게 날먹해도 될까?
if a == "8 7 6 5 4 3 2 1":
    print("descending")
elif a == "1 2 3 4 5 6 7 8":
    print("ascending")
else:
    print("mixed")
