pikachu = ("pi", "ka", "chu")


def is_pikachu(string):
    length = len(string)
    l = 0
    for p in pikachu:
        l += length - len(string.replace(p, ""))
    return "NO" if length > l else "YES"


print(is_pikachu(input()))
