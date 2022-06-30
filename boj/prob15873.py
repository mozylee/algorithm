AB = input()

if len(AB) == 2:
    print(sum(map(int, AB)))
elif len(AB) == 3:
    print(10+int(AB[:1]) if AB[2:] == '0' else 10+int(AB[2:]))
else:
    print(20)
