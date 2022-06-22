X, L, R = map(int, input().split())


print(min((i for i in range(L, R+1)), key=lambda x: abs(X-x)))
