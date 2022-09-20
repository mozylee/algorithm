scores = sorted(((i, int(input()))
                for i in range(1, 8+1)), key=lambda x: -x[1])[:5]

print(sum(map(lambda x: x[1], scores)))
print(*(sorted(map(lambda x: x[0], scores))))
