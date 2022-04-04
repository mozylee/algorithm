credit = list(map(int, input().split()))

if len(set(credit))<3:
    print("S")
    exit(0)

m = max(credit)
s = sum(credit) - m

print("S" if m==s else "N")