def get_str(s1: str, s2: str) -> str:
    ret = (int(s1)+int(s2)) % 10
    return str(ret)


A = input()
B = input()

number = "".join(a+b for a, b in zip(A, B))


while len(number) > 2:
    temp = ""
    for i in range(len(number)-1):
        temp += get_str(number[i], number[i+1])
    number = temp

print(number)
