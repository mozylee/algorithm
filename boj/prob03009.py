coords = [list(map(int, input().split())) for _ in range(3)]

xx = sorted(x for x, _ in coords)
yy = sorted(y for _, y in coords)
x = xx[0] if xx[1] == xx[2] else xx[2]
y = yy[0] if yy[1] == yy[2] else yy[2]
print(x, y)
