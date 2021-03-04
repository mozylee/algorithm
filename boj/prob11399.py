# 출처: https://www.acmicpc.net/problem/11399
# 문제: ATM

_ = input()
total = 0
sum_before = 0

for num in sorted(map(int, input().split())):
    total += sum_before + num
    sum_before += num

print(total)
