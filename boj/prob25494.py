ans = []
for _ in range(int(input())):
    a, b, c = map(int, input().split())
    count = 0
    for x in range(1, a+1):
        for y in range(1, b+1):
            for z in range(1, c+1):
                count += 1 if x % a == y % b == z % c else 0
    ans.append(count)

print(*ans, sep="\n")