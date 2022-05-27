s, numbers = input().split()
s = int(s)

LCD = [[" "]*(s+3)*len(numbers) for _ in range(2*s+3)]


def row(axis: int, level: int):
    for i in range(axis+1, axis+s+1):
        LCD[(s+1)*level][i] = "-"


def column(axis: int, level: int):
    start = (s+1)*level
    for i in range(start+1, start+s+1):
        LCD[i][axis] = "|"


def print_number(index: int, n: int):
    axis = (s+3)*index
    if n not in (1, 4):
        row(axis, 0)
    if n not in (1, 7, 0):
        row(axis, 1)
    if n not in (1, 4, 7):
        row(axis, 2)
    if n not in (1, 2, 3, 7):
        column(axis, 0)
    if n in (2, 6, 8, 0):
        column(axis, 1)
    axis += s+1
    if n not in (5, 6):
        column(axis, 0)
    if n != 2:
        column(axis, 1)


def print_LCD():
    print("\n".join("".join(line) for line in LCD))


for i, n in enumerate(numbers):
    print_number(i, int(n))
print_LCD()
