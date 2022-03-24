S = input()
T = list(input())

while len(T) > len(S):
    if T[-1] == "A":
        T = T[:-1]
    else:
        T = list(reversed(T[:-1]))

print(1 if "".join(T) == S else 0)
