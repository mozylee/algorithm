import sys

read = sys.stdin.readline


initials = {chr(97 + i): 0 for i in range(26)}
for _ in range(int(read())):
    player = read().rstrip()
    initials[player[0]] += 1


filtered_initials = list(filter(lambda x: initials[x] >= 5, initials.keys()))
print(*filtered_initials if len(filtered_initials) > 0 else "PREDAJA", sep="")
