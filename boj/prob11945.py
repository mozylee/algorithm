N,_ = map(int,input().split())

ans = []
for _ in range(N):
    ans.append(input()[::-1])

    print(*ans, sep="\n")