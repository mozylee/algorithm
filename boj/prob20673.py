p, q = (int(input()) for _ in range(2))

if(p<=50 and q<=10):
    print('White')
elif(q>30):
    print('Red')
else:
    print('Yellow')