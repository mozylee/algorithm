X = int(input())

N = 0
for _ in range(int(input())):
    a, b = map(int, input().split())
    N += a*b

print("Yes" if X==N else "No")