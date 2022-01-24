from math import trunc


NUMBERS = {
    "ZERO": "0",
    "ONE": "1",
    "TWO": "2",
    "THREE": "3",
    "FOUR": "4",
    "FIVE": "5",
    "SIX": "6",
    "SEVEN": "7",
    "EIGHT": "8",
    "NINE": "9",
}

expression = input()

for n, v in NUMBERS.items():
    expression = expression.replace(n, v)

before = False
expression = expression.replace("x", "*")
num = ""
for c in expression:
    if c.isalpha() or (before and not c.isnumeric()):
        print("Madness!")
        exit(0)
    if not c.isnumeric():
        before = True
        num = str(trunc(eval(num))) + c
        continue
    before = False
    num += c


print(expression.replace("*", 'x'))
num = str(trunc(eval(num[:-1])))

for n, v in NUMBERS.items():
    num = num.replace(v, n)
print(num)
