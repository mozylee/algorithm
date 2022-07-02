s = input()
bomb = list(reversed(input()))
length = len(bomb)

stack = []

for c in s:
    if c != bomb[0]:
        stack.append(c)
        continue

    if len(stack) < length-1:
        stack.append(c)
        continue

    flag = True
    for i in range(1, length):
        if stack[-i] != bomb[i]:
            flag = False
            break

    if flag:
        for i in range(length-1):
            stack.pop()
    else:
        stack.append(c)

print("".join(stack) if len(stack) > 0 else "FRULA")
