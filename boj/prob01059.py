L = int(input())
S = sorted(map(int, input().split()))
N = int(input())

smaller, bigger = 1, 1000

for i in S:
    if i < N:
        smaller = i+1
        continue
    if i == N:
        print(0)
        exit(0)
    if i > N:
        bigger = i-1
        break
    
print((N-smaller+1)*(bigger-N+1) - 1)
