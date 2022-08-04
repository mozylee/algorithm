N, M = map(int, input().split())
A = [list(map(int, input().split())) for _ in range(N)]
B = [list(map(int, input().split())) for _ in range(N)]

for a, b in zip(A, B):
    for i1, i2 in zip(a, b):
        print(i1+i2, end=" ")
    print()