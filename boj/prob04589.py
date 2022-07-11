
import sys


read = sys.stdin.readline

ans = []
for _ in range(int(input())):
    A, B, C = map(int, read().split())

    ordered = A <= B <= C
    reverse = A >= B >= C

    ans.append("Ordered" if ordered or reverse else "Unordered")

print("Gnomes:", *ans, sep="\n")
