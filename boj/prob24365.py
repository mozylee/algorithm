A, B, C = map(int, input().split())

avg = (A+B+C)//3

ans = 0
if B < avg:
    ans = 3*avg - B - 2*A
elif B > avg:
    ans = B + 2*C - 3*avg
else:
    ans = 2*(C-avg)

print(ans)
