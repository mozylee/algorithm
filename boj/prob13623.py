A, B, C = map(int, input().split())
check = ((A, 'A'), (B, 'B'), (C, 'C'))

check = sorted(check)

if check[0][0] == check[1][0] and check[1][0] == check[2][0]:
    print('*')
elif check[0][0] == check[1][0]:
    print(check[2][1])
else:
    print(check[0][1])
