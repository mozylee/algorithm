n = int(input())
k = int(input())
limit = 60 + k
s = (1500 * n) if n <= limit else (1500*limit + 3000*(n-limit))


print(s)
