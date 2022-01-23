from math import factorial


def get_cases(N, M):
    return factorial(N+M)//(factorial(N if N else 1)*factorial(M if M else 1))


N, M, K = map(int, input().split())

if K > get_cases(N, M):
    print(-1)
    exit(0)

ret = ""
while N+M > 0:
    if N == 0:
        ret += 'z'*M
        break
    if M == 0:
        ret += 'a'*N
        break
    if K <= get_cases(N-1, M):
        ret += 'a'
        N -= 1
    else:
        ret += 'z'
        K -= get_cases(N-1, M)
        M -= 1
print(ret)
