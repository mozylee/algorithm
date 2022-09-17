
woolim, startlink = 0, 0

for w, s in zip(map(int, input().split()), map(int, input().split())):
    woolim += w
    if woolim > startlink:
        print("Yes")
        break
    startlink += s
else:
    print("No")
