name, age, weight = input().split()

while name != "#":
    print(name, "Senior" if int(age) > 17 or int(weight) >= 80 else "Junior")
    name, age, weight = input().split()
