l,r = map(int,input().split())
max2 = max(l,r)*2
if l==r==0:
    print("Not a moose")
elif l==r:
    print(F"Even {max2}")
else:
    print(f"Odd {max2}")