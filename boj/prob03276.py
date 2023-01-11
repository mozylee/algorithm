import sys

read = sys.stdin.readline

N = int(read())

min_rc = 1e9
min_tuple = (10, 10)
for i in range(1, 11):
    if i**2 > N:
        break

    for j in range(i,11):
        if i*j>=N and min_rc > i+j:
            min_rc = i+j
            min_tuple = (i,j)

print(*min_tuple)