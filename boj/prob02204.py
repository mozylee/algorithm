n = int(input())

while n>0:
    words = list(input() for _ in range(n))
    print(min(words, key = lambda x: x.lower()))
    n = int(input())