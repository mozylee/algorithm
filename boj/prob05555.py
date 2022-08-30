
import sys


read = sys.stdin.readline
string = read().rstrip()
length = len(string)
ans = 0
for _ in range(int(read())):
    n = read().rstrip()*2
    ans += 1 if n.find(string) > -1 else 0

print(ans)
