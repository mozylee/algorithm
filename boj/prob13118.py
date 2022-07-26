points = list(map(int, input().split()))
x, y, r = map(int, input().split())

for i, p in enumerate(points):
    if p==x:
        print(i+1)
        exit(0)

print(0)
