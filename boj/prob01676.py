# 출처: https://www.acmicpc.net/problem/1676
# 문제: 팩토리얼 0의 개수


# n=int(input())
# print(n // 5 + n // 25 + n // 125)
def count5(n):
    count = 0
    while not n % 5:
        count += 1
        n //= 5
    return count


results = [count5(i) for i in range(1, int(input()) + 1) if i % 5 == 0]

print(sum(results))
