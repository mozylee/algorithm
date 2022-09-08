A, B, N = map(int, input().split())

for i in range(N+1):
    digit = A // B
    A = (A % B)*10

    if i == N:
        print(digit)
    
