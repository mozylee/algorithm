ans = []

for _ in range(2):
    T, F, S, P, C = map(int, input().split())
    ans.append(6*T+3*F+2*S+P+2*C)

print(*ans)