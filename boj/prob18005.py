n = int(input()) 

if (n*(n+1)//2) % 2 == 0:
    print(2 if n % 2 == 0 else 0)
else:
    print(1 if n % 2 == 0 else 0)
