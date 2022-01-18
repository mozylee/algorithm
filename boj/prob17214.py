polynomial = list(input().split("x"))

if len(polynomial) > 1:
    polynomial[0] = int(polynomial[0])//2
    if abs(polynomial[0]) > 1:
        print(polynomial[0], end="")
    else:
        print("" if polynomial[0] > 0 else "-", end="")
    print('xx', end="")
    if polynomial[1] != "" and polynomial[1] != "0":
        polynomial[1] = int(polynomial[1])
        print("+" if polynomial[1] >= 0 else "", end="")
        if abs(polynomial[1]) > 1:
            print(polynomial[1], end="")
        else:
            print("" if polynomial[1] > 0 else "-", end="")
        print('x', end="")
else:
    if polynomial[0] != "" and polynomial[0] != "0":
        polynomial[0] = int(polynomial[0])
        if abs(polynomial[0]) > 1:
            print(polynomial[0], end="")
        else:
            print("" if polynomial[0] > 0 else "-", end="")
        print('x'*1, sep="", end="")
print("+W" if polynomial[0] != "0" else "W")
