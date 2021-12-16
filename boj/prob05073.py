answer = []
while True:
    a, b, c = sorted(map(int, input().split()), reverse=True)
    if a == b and b == c and a == 0:
        break

    message = ""
    if a >= b + c:
        message = "Invalid"
    elif a == b == c:
        message = "Equilateral"
    elif a == b or a == c or b == c:
        message = "Isosceles"
    else:
        message = "Scalene"
    answer.append(message)

print(*answer, sep="\n")
