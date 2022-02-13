def rev(n):
    return int("".join(reversed(str(n))))


X, Y = map(rev, input().split())

print(rev(X+Y))
