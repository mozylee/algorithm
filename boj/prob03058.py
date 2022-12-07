import sys


read = sys.stdin.readline

ans = []
for _ in range(int(read())):
    evens = [i for i in map(int, read().split()) if i % 2 == 0]

    ans.append(f"{sum(evens)} {min(evens)}")

print(*ans, sep="\n")
