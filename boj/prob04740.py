import sys


read = sys.stdin.readline

ans=[]
while (line := read()[:-1])!="***":
    ans.append(line[::-1])

print(*ans, sep="\n", end="")