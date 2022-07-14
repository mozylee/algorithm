import sys


read = sys.stdin.readline
ans = ""

while True:
    if (line := read().rstrip()) == "END":
        break
    ans += line[::-1] + "\n"

print(ans, end = "")
