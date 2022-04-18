UCPC = "UCPC"
index = 0

for c in input():
    if c == UCPC[index]:
        index += 1
        if index == 4:
            break

print("I love UCPC" if index==4 else "I hate UCPC")
