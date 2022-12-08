import sys


read = sys.stdin.readline

ans = []

temperature = float(read())
while (next:=float(read()))<=200:
    ans.append(f"{next-temperature:.2f}")
    temperature = next

print(*ans, sep="\n")