import sys


read = sys.stdin.readline


N = int(read())

ans = []
while (C := int(read())) > 0:
    ans.append(f"{C} is a multiple of {N}."
               if C % N == 0 else f"{C} is NOT a multiple of {N}.")

print(*ans,sep="\n")