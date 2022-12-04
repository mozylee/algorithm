import sys


read = sys.stdin.readline

ans = []
for _ in range(int(read())):
    read()
    candies = [int(read()) for _ in range(int(read()))]

    ans.append("YES" if sum(candies)%len(candies)==0 else "NO")

print(*ans, sep="\n")