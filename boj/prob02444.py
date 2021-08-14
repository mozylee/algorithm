n = int(input())
for i in list(range(n))+list(range(n-2, -1, -1)):
    print(" "*(n-i-1)+"*"*(2*i+1))
