wolfs = set("w" * i + "o" * i + "l" * i + "f" * i for i in range(1, 13))


line = input()
index = 0
while index < len(line):
    flag = False
    for w in wolfs:
        if line[index:].startswith(w):
            index += len(w)
            flag = True
    if not flag:
        break

print(1 if index == len(line) else 0)
