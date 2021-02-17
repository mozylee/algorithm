# Backjoon Online Judge: https://www.acmicpc.net/problem/10872
# 내용없음

n = int(input())
if n > 1:
    result = 1
    for i in range(2, n + 1):
        result *= i
    print(result)
else:
    print(1)
