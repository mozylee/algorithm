# 출처: https://www.acmicpc.net/problem/2460
# 문제: 지능형 기차 2


people = [0]*11
max_value = -1
for i in range(10):
    off, on = map(int, input().split())
    people[i+1] = people[i]-off+on
    if people[i+1] > max_value:
        max_value = people[i+1]
        if max_value >= 10000:
            print(10000)

print(max_value)
